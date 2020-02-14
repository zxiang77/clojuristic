(ns dao.dbase
  (:require [monger.collection :as mc]
            [monger.core :as mg])
  (:import [org.bson.types ObjectId]))
;;; The dao.dbase file provides utility for CRUD operations with database, the question remains if
;;; database facing code (all code involving CRUD operations) should be contained in this package or
;;; it's tolerable to have them appear in service class

;;; future integration: transaction operation


(defn find
  "Example (find (map->user {:id 111})) if I want to search user with an id = 111"
  [model, & args]
  (
    let [conn (mg/connect)
         type (type model)
         dbName "<get DB Name given type>"
         collectionName "<get Collection Name given type>"
         db   (mg/get-db conn dbName)]
    (mc/find db collectionName model)))
;; todo: I can use the constructor as the type
(defn insert
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])

(defn remove
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])

(defn update
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])

(defn findById [type id]
  (find (type {:id id})))

(defn findAll [type]
  (find (type {})))