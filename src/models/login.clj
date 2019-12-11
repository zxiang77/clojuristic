(ns models.login)

(defrecord loginform [uname, upass, token])

(defn makeLogin [uname, upass, token]
  (->loginform uname upass token))


