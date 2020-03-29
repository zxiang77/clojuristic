(ns svc.user
  (:require [dao.dbase :as based]
            [models.user :as userm :refer :all]
            [clojure.string :as string]
            [dao.user :as userd])
  (:import [org.bson.types ObjectId]
           (models.user user)
           (java.math BigInteger)
           (org.apache.commons.codec.digest DigestUtils)))

(def NAME_MAX_LENGTH 20)

(defn matches [regex expr]
  (let [m (re-matcher regex expr)]
    (. m matches)))
(def NAME_REGEX (re-pattern "^[A-z][A-z0-9]{3,19}"))


(def PASSWORD_REGEX (re-pattern "[A-z0-9 !@#$%\\^&\\*()_+\\-=\\[\\]\\{\\}|;':\",.\\/<>\\?]+"))

(def EMAIL_REGEX (re-pattern "[A-z0-9][A-z0-9!#$%&'*+\\/=?^_`{|}~-]*@[A-z0-9][A-z0-9\\-]*(\\.[A-z0-9][A-z0-9\\-]*)*"))

(defn between? [num min max]
  (and (>= num min) (<= num max)))

(defn validate-field [regex field min max]
  (if (between? (count field) min max)
    (matches regex field) false))

;; (?:"?([^"]*)"?\s)?(?:<?(.+@[^>]+)>?) good to know, matches "Joe Doe" <joedoe@example.com> with capturing group
;; todo impl
(defn validateName [^String name]
  (and
    (validate-field NAME_REGEX name 5 20)
    (= 0 (count (based/db-find-maps (make-user {:name name}) {:limit 1})))))

(defn validateEmail [^String email]
  (validate-field EMAIL_REGEX email 3 64))

(defn validatePass [^ String pass]
  (validate-field PASSWORD_REGEX pass 6 45))

;; check if existing user exists
;; todo: should throw exception here and handle the exception in the middleware
(defn validate [^user user]
  (let [
        nameValidated (validateName (:name user))
        passValidated (validatePass (:password user))
        emailValidated (validateEmail (:email user))]
    (if (and nameValidated passValidated emailValidated)
      user
      {:name nameValidated :password passValidated :email emailValidated})))

;; Reference: https://gist.github.com/jizhang/4325757 , can use BigInteger as well
(defn post-password [^String password]
  (->> password
       .getBytes
       DigestUtils/sha256Hex))

(defn post-process [r-user]
  "post processing a user, add salt and hashing for a user"
  (assoc r-user :password (post-password (:password r-user)) :id (ObjectId.)))

;; make i should consider putting the validation here
(defn create [r-user]
  (let [result (validate r-user)]
    (if (instance? user result)
      (let [completeUser (post-process user)] ;; %) indicates it takes one param
        (based/db-insert completeUser) true)
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
