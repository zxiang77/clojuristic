(ns models.user
  (:require [models.base :refer [table coll]]))

(defrecord user [id, name, upass])

(defmethod table user "info")
(defmethod coll user "user")
;; filter


;; use :skip to skip the field, to differentiate with null values
(defn make-user [{:keys [id name upass], :or {id :skip name :skip upass :skip}}]
  (->user id name upass))

(def TYPE (-> {} make-user type))
