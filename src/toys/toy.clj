(ns toys.toy)

(defprotocol toy
  (bar-me [p1] [p1 p2])) ;; this means bar-me has 2 different types of paramters set


(deftype toyimpl [a b c]
  toy
  (bar-me [p1] ([p1 a b]))
  (bar-me [p1 p2] ([p1 p2 c])))

(defn maketoy [a b c]
  (toyimpl. a b c))

;; place multimethods here