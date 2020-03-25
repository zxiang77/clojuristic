(ns models.user
  (:require [models.base :refer :all]))

(defrecord user [id, name, upass email])

(defmethod table [user] [_] "info")
(defmethod coll [user] [_] "user")
;; filter


;; use :skip to skip the field, to differentiate with null values
(defn make-user [{:keys [id name email upass], :or {id :skip email :skip name :skip upass :skip}}]
  (->user id name upass email))
