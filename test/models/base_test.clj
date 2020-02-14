(ns models.base-test
  (:require [clojure.test :refer :all]
            [models.base :refer :all]
            [models.user :refer :all]))

(deftest get-table-string-test
  (testing "getTableStringByType should return the right table string")
  (let [obj (make-user {})]
    (is (= "user" (getTableStringByType ->user)))))

(deftest to-query-test
  (testing "toQuery should apply :table metadata to a record"
    (let [mdel (make-user {})]
      (is (= (-> mdel (toQuery ->user) meta :table) "user")))
    ))
;;; read https://clojure.org/guides/threading_macros
;;; -> thread-first: fill in the previous value to the first parameter of the next func in the pipeline
;;; ->> thread-last: fill in the previous value to the last  parameter of the next func in the pipeline