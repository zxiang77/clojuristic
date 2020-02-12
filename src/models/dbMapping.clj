(ns models.dbMapping
  (:require [models.user :refer :all])
  )

(def DB_MAPPING {
    (type (make-user {})) "user"
  })
