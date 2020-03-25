(ns svc.user
  (:require [dao.dbase :as based]
            [models.user :as userm])
  (:import [org.bson.types ObjectId]))

(def NAME_MAX_LENGTH 20)

;; make i should consider putting the validation here
(defn create [user]
  (let [completeUser (update user :id #(ObjectId.) %)]      ;; %) indicates it takes one param
    (based/insert completeUser)))

(defn between [num min max]
  (and (> num min) (<= num max))
  ;; validate with regex, check if there is conflict in db
  )

(defn validateName [name]
  (between (count name) 0 NAME_MAX_LENGTH)
  (re-find (re-pattern "\\d+") name))                 ;; todo: how to use regex

;; todo impl
(defn validateEmail [email])
(defn validatePass [email])

(defn validate [{:keys [userName password email]}]
  (let [nameValidated (validateName (:name userName))
        passValidated (validatePass (:password password))
        emailValidated (validateEmail (:email email))]
    (if (and nameValidated passValidated emailValidated)
      (userm/make-user {:name userName :email email :upass password})
      (nil))))
