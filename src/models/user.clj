(ns models.user
  (:require [models.base :refer :all]))

(defrecord user [id, name, upass])

(defmethod table [user] [_] "info")
(defmethod coll [user] [_] "user")
;; filter


;; use :skip to skip the field, to differentiate with null values
(defn make-user [{:keys [id name upass], :or {id :skip name :skip upass :skip}}]
  (->user id name upass))
