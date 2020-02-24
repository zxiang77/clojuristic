(ns models.base)       ;; separate import

(defmulti table (fn [obj] [(type obj)]))
(defmulti coll (fn [obj] [(type obj)]))
