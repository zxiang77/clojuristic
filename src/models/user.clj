(ns models.user
  (:require [models.base :refer :all]))

(defrecord user [id, name, password email])

(defmethod table [user] [_] "info")
(defmethod coll [user] [_] "user")
;; filter


;; use :skip to skip the field, to differentiate with null values
(defn make-user [{:keys [id name email password], :or {id :skip email :skip name :skip password :skip}}]
  (->user id name password email))
