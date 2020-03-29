(ns models.user-test
  (:require [clojure.test :refer :all]
            [models.user :refer :all]))

(deftest make-empty-user-test
  (testing "Test test for make-user"
           (is (= (make-user {}) (->user :skip :skip :skip :skip)))))

(deftest make-user-test
  (testing "Test test for make-user"
           (is (= (make-user {:name "Zili"}) (->user :skip "Zili" :skip :skip)))))
