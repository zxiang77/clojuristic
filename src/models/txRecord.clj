(ns models.txRecord)
;;; The transaction record should be interfacing the Plaid API, not database, if the data needs to be persisted,
;;; should mention that in the terms of services or handle the security carefully

(defrecord TxRecord [id amount time])