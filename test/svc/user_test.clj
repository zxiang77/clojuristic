(ns svc.user-test
  (:require [clojure.test :refer :all]
            [svc.user :refer :all]))

;(defn verify [f expected]
;  (fn [param] (is (= expected (f param)))))

(deftest validate-name-test
  (testing "should fail on invalid names"
    (is (= (validateName "") false))
    (is (= (validateName "kfc") false))
    (is (= (validateName "1kfkfkfdf") false))
    (is (= (validateName "kfk%%%fkfdf") false))
    (is (= (validateName "ksdflksjflksdfjklejlsk322") false))
    (is (= (validateName "ksdflksjflksdfjkle32jlsk322") false)))
  (testing "should success on valid name"
    (is (= (validateName "ksdfjklejlsk322") true))
    (is (= (validateName "zilisleep2") true)))
  )

(deftest validate-email-test
  (testing "should fail on invalid email"
    (is (= (validateEmail "@1") false))
    (is (= (validateEmail "-12.") false))
    (is (= (validateEmail "-12.@gmail.com") false))
    (is (= (validateEmail "121.@-gmail.com") false))
    (is (= (validateEmail "verrr1111111111111111111111111111111111111111111111rrrrrrrrrrrrrrrrrrrrrrrrylooooooong@gmail.com") false))
    )
  (testing "should pass on valid email"
    (is (= (validateEmail "att@test") true))
    (is (= (validateEmail "att@test.com") true))
    ))

(deftest validate-password-test
  (testing "should fail on invalid password"
    (is (= (validatePass "@1") false))
    )
  (testing "should pass on valid password"
    (is (= (validatePass "att@test") true))
    (is (= (validatePass "=[]{}|;':\",./<>?") true))
    (is (= (validatePass "att!@#$%^&*()_+-") true))
    ))


