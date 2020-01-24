(ns models.user)

(defrecord user [id, name, upass])
(
  def USER_TABLE
  #{
    (->user 1 "Dongdong" "weakpassword")
    (map->user {:id 2, :name "Zili", :upass "sTr0nG9A55wOr6!"})
    }
  )

;; filter
(defn lookup-user [uname, upass]
  ())

(defn query-all []
  (USER_TABLE))

;; use :skip to skip the field, to differentiate with null values
(defn make-user [{:keys [id name upass], :or {id :skip name :skip upass :skip}}]
  (->user id name upass))
