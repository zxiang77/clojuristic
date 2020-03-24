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
  (POST "/register" {body :body}
    ;; todo: complete the register logic and other user apis
    (println (clojure.string/join ", " [body])))
  ))
;; test wget
;; wget --post-data 'userName=diif&password=ddd&email=iv@lsl.c' localhost:3000/api/user/register

;; note: use slurp to cast objects to strings