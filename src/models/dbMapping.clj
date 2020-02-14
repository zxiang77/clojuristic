(ns models.dbMapping
  (:import [models.user user])
  )

(def DB_MAPPING {
    user "user"
  })
(def :user/db-info {:user/db-name "models" :user/collection-name "users"})