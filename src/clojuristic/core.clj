(ns clojuristic.core
  (:require
    [models.availability :as aval]
    [monger.collection :as mc]
    [api.restful.base :as api]
    [monger.core :as mg])
    (:import [org.bson.types ObjectId])
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
  "Propagate environment variables, start request handler, "
  [& args]
  (api/app)
  )
