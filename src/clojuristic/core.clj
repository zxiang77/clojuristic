(ns clojuristic.core
    (:require [models.availability :as aval])
    (:gen-class))

;(require '[models.availability])
;(refer 'models.availability)

;;; /\ and \/ are equivalent
;(use 'models.availability)
;(require '[models.availability] :as aval)
;

;(defn getstr
;  [name]
;  (str "Hello " name))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (aval/getstr "bla")))
