(ns utils.validators)
(defprotocol validator
  (validate [data]))

(deftype multi-validator []
  validator
  (validate [p] (p))
  )

;; use multimethods to define validator