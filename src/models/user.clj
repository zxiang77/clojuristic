(ns models.user
  (:require [models.base :refer :all])
  (:import (org.bson.types ObjectId)))

;; user schema: _id: ObjectId, name: String, password: String, email String, emailValidated boolean, cookies Array<Cookie>
;; Cookie schema: cookie: String,

(defrecord user [_id, ^String name, ^String password, ^String email])

(defmethod table [user] [_] "user")
(defmethod coll [user] [_] "creds")
;; filter
;; cookies field, allows up to 5 cookies, once limit reached, kicks off older cookie,
;; but still need a cookie collection to easier lookup username by cookie and check uniqueness
;; design the payload of the POST request: [userId, cookie, ...] then we can easily lookup the cookie by userId
;;

;; use :skip to skip the field, to differentiate with null values
(defn make-user [{:keys [^ObjectId _id name email password], :or {_id :skip email :skip name :skip password :skip}}]
  (->user _id name password email))
