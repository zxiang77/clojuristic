(ns models.base
  (:require [models.dbMapping :refer [DB_MAPPING] ]))       ;; separate import

(defprotocol Queriable
  (toQuery [this]))

(defmulti table (fn [obj] [type obj]))
(defmulti coll (fn [obj] [type obj]))

(defn getTableStringByType
  [type] (get DB_MAPPING type))

(defn toQuery
  "Simply add the table name to the record as its metadata, should probably do it on construction"
  [queriable type]
  (vary-meta queriable merge {:table (getTableStringByType type)}))
