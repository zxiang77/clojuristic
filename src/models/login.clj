(ns models.login)


; define a protocol for authentication
; mock data retrieval from db
(defprotocol Auth
  (auth []))

(defrecord loginform [uname, upass]
    Auth
    (auth []
      (let [data (lookup "user" uname, upass)] ;; more destructing may needed here
       )))

(defrecord tokenform [token]
    Auth
  (auth []
    ()))

(defn lookup [table ..name]
  ())

(defn makeLogin [uname, upass]
  (->loginform uname upass))

(defn makeToken [token]
  (->tokenform [token]))




