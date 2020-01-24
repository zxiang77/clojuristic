(ns clojuristic.core
  (:require
    [models.availability :as aval]
    [monger.collection :as mc]
    [monger.core :as mg])
    (:import [org.bson.types ObjectId]
             [com.mongodb DB WriteConcern])
    (:gen-class))

;(require '[models.availability])
;(refer 'models.availability)

;;; /\ and \/ are equivalent
;(use 'models.availability)
;(require '[models.availability] :as aval)
;


; use scala/java spring! for safely typing (data retrieval level), use clojure to implement biz rules
; for clean architecture, clojure should be a inner circle
; spring be the db adapter layer, add a framework dependency here, but it's fine, because we can replace it
; with other adapters later.
; clojure part should fetch data from db layer and use those for biz logic processing
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ((println (aval/getstr "bla"))
   (let [conn (mg/connect)
        db   (mg/get-db conn "monger-test")
        oid  (ObjectId.)
        doc  {:first_name "John" :last_name "Lennon"}]
   (mc/insert db "documents" (merge doc {:_id oid})))
   (println (aval/getstr "done!"))))
