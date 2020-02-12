(ns dao.dbase
  (:require [monger.collection :as mc]
            [monger.core :as mg])
  (:import [org.bson.types ObjectId]))
;;; The dao.dbase file provides utility for CRUD operations with database, the question remains if
;;; database facing code (all code involving CRUD operations) should be contained in this package or
;;; it's tolerable to have them appear in service class

;;; future integration: transaction operation


(defn find
  "The find method take a query and optional as parameters and then query the mongodb. The query object
  is expected to be a model subclass, which contains table info"
  [query, &options]
  (
    let [conn (mg/connect)
         table ""
         db   (mg/get-db conn "monger-test")
         oid  (Ob jectId.)
         doc  {:first_name "John" :last_name "Lennon"}]
    (mc/insert db "documents" (merge doc {:_id oid}))))

(defn insert
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])

(defn remove
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])

(defn update
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])