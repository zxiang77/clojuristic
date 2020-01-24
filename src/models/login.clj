(ns models.login
  (require [models.user :as user]))


; define a protocol for authentication
; mock data retrieval from db
(defprotocol Auth
  (auth []))

(defrecord loginform [uname, upass]
    Auth
    (auth []
      (let [data (user/lookup-user uname, upass)] ;; more destructing may needed here
)))

(defrecord tokenform [token]
    Auth
  (auth []
    ()))

(defn makeLogin [uname, upass]
  (->loginform uname upass))

(defn makeToken [token]
  (->tokenform [token]))




