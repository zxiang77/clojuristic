(ns models.base-test
  (:require [clojure.test :refer :all]
            [models.base :refer :all]
            [models.user :refer :all]))

;;; read https://clojure.org/guides/threading_macros
;;; -> thread-first: fill in the previous value to the first parameter of the next func in the pipeline
;;; ->> thread-last: fill in the previous value to the last  parameter of the next func in the pipeline