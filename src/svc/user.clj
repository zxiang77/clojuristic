(ns svc.user
  (:require [dao.dbase :as based]
            [models.user :as userm])
  (:import [org.bson.types ObjectId]))

(defn create [uname upass]
  (let [oid (ObjectId.)
        usero (userm/->user oid uname upass)]
    (based/insert usero)))