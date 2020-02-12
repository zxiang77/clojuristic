(ns toys.toy)

(defprotocol toy
  (bar-me [p1] [p1 p2])) ;; this means bar-me has 2 different types of paramters set


(deftype toyimpl [a b c]
  toy
  (bar-me [p1] ([p1 a b]))
  (bar-me [p1 p2] ([p1 p2 c])))

(defn maketoy [a b c]
  (toyimpl. a b c))

;; set tooling
(def seteg #{"Alice", "Bob", "Kelly"})
(conj seteg "new elm") ; adding element
(disj seteg "Alice") ; removing element
(contains? seteg "Alice") ; checking containment
(conj (sorted-set) "bravo" "hack" "abbrev")
(into seteg #{"fa"}) ; join

;; map tooling
(def scores {"Fred"  1400
   "Bob"   1240
   "Angela" 1024})

;; same as put() in java
(assoc scores "Sally" 0)
;; rm data
(dissoc scores "Bob")
;; get
(get scores "Angela")
(scores :Angela) ; if the map is used as constant lookup table
(:Angela scores) ; if the map is used as constant lookup table

;; get with default
(get scores "Angela" 22)
(scores :Angela 22) ; if the map is used as constant lookup table

;; all keys, all vals
(keys scores)
(vals scores)

;; if macro is used when we have if else structure
(if (even? 5)
  (do (println "even")
    true)
  (do (println "odd")
    false))

;; when is used when only 1 then no else
(when (neg? x)
  (throw (RuntimeException. (str "x must be positive: " x))))

;; it's for a series of if conditions, :else is optional
(let [x 11]
  (cond
    (< x 2)  "x is less than 2"
    (< x 10) "x is less than 10"
    :else  "x is greater than or equal to 10"))

;; switch loop
(defn foo [x]
  (case x
    5 "x is 5"
    10 "x is 10"
    "x isn't 5 or 10"))

;; method chaining
(defrecord eg [a b c])
(let [ak (eg. "a" "b" "c")] (-> ak -> type -> type)
                            (let [bk (eg. "b" "c" "d")] (meta bk)))

;; place multimethods here