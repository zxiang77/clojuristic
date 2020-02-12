(ns models.base-test
  (:require [clojure.test :refer :all]
            [models.base :refer :all]
            [models.user :refer :all]))

(deftest get-table-string-test
  (testing "getTableStringByType should return the right table string")
  (let [obj (make-user {})]
    (is (= "user" (getTableStringByType obj)))))

(deftest to-query-test
  (testing "toQuery should apply :table metadata to a record"
    (let [mdel (make-user {})]
      (is (= (-> mdel toQuery meta :table) "user")))
    ))
