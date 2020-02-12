(ns models.base
  (:require [models.dbMapping :refer [DB_MAPPING] ]))       ;; separate import

;(defprotocol factory
;  "The factory protocol will spawn a "
;  [])
;
;(def DB_MAPPING
;  #{
;    models.user "user"
;    })

(defprotocol Queriable
  (toQuery [this]))


(defn getTableStringByType
  [obj] (get DB_MAPPING (type obj)))

(defn toQuery
  "Simply add the table name to the record as its metadata, should probably do it on construction"
  [queriable]
  (vary-meta queriable merge {:table (getTableStringByType queriable)}))
