(ns dao.dbase
  (:require [monger.collection :as mc]
            [monger.core :as mg])
  (:import [org.bson.types ObjectId]))
;;; The dao.dbase file provides utility for CRUD operations with database, the question remains if
;;; database facing code (all code involving CRUD operations) should be contained in this package or
;;; it's tolerable to have them appear in service class

;;; future integration: transaction operation


(defn find
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])

(defn insert
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])

(defn remove
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])

(defn update
  "The find method take a query and optional as parameters and then query the mongodb"
  [query, &options])