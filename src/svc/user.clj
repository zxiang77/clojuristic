(ns svc.user
  (:require [dao.dbase :as based]
            [models.user :as userm :refer :all]
            [clojure.string :as string])
  (:import [org.bson.types ObjectId]
           (models.user user)))

(def NAME_MAX_LENGTH 20)

(defn matches [regex expr]
  (let [m (re-matcher regex expr)]
    (. m matches)))
(def NAME_REGEX (re-pattern "^[A-z][A-z0-9]{3,19}"))


(def PASSWORD_REGEX (re-pattern "^[A-z0-9 ]{5,20}"))

(def EMAIL_REGEX (re-pattern "[A-z0-9][A-z0-9!#$%&'*+\\/=?^_`{|}~-]{4,20}@[A-z0-9][A-z0-9!#$%&'*+\\/=?^_`{|}~-]*(\\.[A-z0-9][A-z0-9!#$%&'*+\\/=?^_`{|}~-]*)+"))

(defn between? [num min max]
  (and (>= num min) (<= num max)))

(defn validate-field [regex field min max]
  (if (between? (count field) min max)
    (matches regex field) false))

;; (?:"?([^"]*)"?\s)?(?:<?(.+@[^>]+)>?) good to know, matches "Joe Doe" <joedoe@example.com> with capturing group
;; todo impl
(defn validateName [name]
  (validate-field NAME_REGEX name 5 20))

(defn validateEmail [email]
  (validate-field EMAIL_REGEX email 3 70))

(defn validatePass [pass]
  (validate-field PASSWORD_REGEX pass 6 30))

;; check if existing user exists
(defn validate [user]
  (let [
        nameValidated (validateName (:name user))
        passValidated (validatePass (:password user))
        emailValidated (validateEmail (:email user))]
    (if (and nameValidated passValidated emailValidated)
      user
      {:name nameValidated :password passValidated :email emailValidated})))

;; make i should consider putting the validation here
(defn create [r-user]
  (let [result (validate r-user)
        oid (ObjectId.)]
    (if (instance? user result)
      (let [completeUser (update r-user :id (fn [] oid))] ;; %) indicates it takes one param
        (based/insert completeUser) true)
      result)))

;; https://www.thepolyglotdeveloper.com/2015/05/use-regex-to-test-password-strength-in-javascript/
;; () represent each capturing group, and [] represent the set of characters allowed or excluded for a part of substring
;; {} for the length of the part of the substring

;; repl notes: (load "/svc/user")
;; (ns svc.user)
;; (use 'your.namespace :reload) to reload
(def tester (fn [regex]
              (let [pat (re-pattern regex)
                    f (fn [name] (re-find pat name))]
                f)))
