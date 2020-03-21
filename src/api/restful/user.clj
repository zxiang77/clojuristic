(ns api.restful.user
  (:require [compojure.core :refer :all]
            [hiccup.core :refer :all]
            [svc.user :as usersvc]
            [clojure.data.json :as json]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

;;
(defroutes user-route (context "/api/user" []
  (GET "/" [id] (html [:h1 (str "Hello user " id)]))
  (POST "/" [uname upass]
    (usersvc/create uname upass)
    (html [:h1 (str "Hello user " uname)]))
  (POST "/seaseme" [] (json/write-str {:isAuthenticated true}))
  (POST "/register" [userName email password :as r & z]
    (println (clojure.string/join ", " [userName email password (:body r) z])))
  ))
