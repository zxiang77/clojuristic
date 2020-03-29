(ns dao.dbase
  (:require [monger.collection :as mc]
            [monger.core :as mg]
            [models.base :refer [coll table]]))
;;; The dao.dbase file provides utility for CRUD operations with database, the question remains if
;;; database facing code (all code involving CRUD operations) should be contained in this package or
;;; it's tolerable to have them appear in service class

;;; future integration: transaction operation


(defn- parse [query]
  (into {} (filter (fn [v] (not= (second v) :skip)) query)))


(defn db-find
  "Example (find (map->user {:id 111})) if I want to search user with an id = 111"
  [model, & args]
  (
    let [conn (mg/connect)
         dbName (table model)
         collectionName (coll model)
         db   (mg/get-db conn dbName)
         query (parse model)]

    (mc/find db collectionName query)))

(defn db-find-maps
  "Example (find (map->user {:id 111})) if I want to search user with an id = 111"
  [model, & args]
  (
    let [conn (mg/connect)
         dbName (table model)
         collectionName (coll model)
         db   (mg/get-db conn dbName)
         query (parse model)]
    (mc/find-maps db collectionName query args)))

;; todo: I can use the constructor as the type
(defn db-insert
  "The find method take a query and optional as parameters and then query the mongodb"
  [model, & options]
  (let [conn (mg/connect)
        dbName (table model)
        coll (coll model)
        db   (mg/get-db conn dbName)
        query (parse model)]
    (mc/insert db coll query)))

(defn db-remove
  "The find method take a query and optional as parameters and then query the mongodb"
  [model, & options]
  (let [type (type model)
        dbName (table type)
        coll (coll type)
        query (parse model)]
    (mc/remove dbName coll query)))

(defn db-update
  "The find method take a query and optional as parameters and then query the mongodb
  may need to override :multi with & options"
  [model, update, & options]
  (let [query (parse model)
        updatequery (parse update)
        type (type model)
        dbName (table type)
        coll (coll type)]
    (mc/update dbName coll query updatequery {:multi true})))

(defn aggreg
  "The endpoint for aggregation"
  [type queries & options]
  (let [dbName (table type)
        coll (coll type)]
    (mc/aggregate dbName coll queries)))

(defn findById [type id]
  (db-find (type {:id id})))
;
;(defn findAll [type]
;  (find (type {})))

;(defmacro empty-model [type]
;  (let [constr ]))