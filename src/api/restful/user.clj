(ns api.restful.user
  (:require [compojure.core :refer :all]
            [hiccup.core :refer :all]
            [svc.user :as usersvc]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

;;
(defroutes user-route (context "/user" []
  (GET "/" [id] (html [:h1 (str "Hello user " id)]))
  (POST "/" [uname upass]
    (usersvc/create uname upass)
    (html [:h1 (str "Hello user " uname)]))
  ))
