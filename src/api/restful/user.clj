(ns api.restful.user
  (:require [compojure.core :refer :all]
            [hiccup.core :refer :all]
            [svc.user :as usersvc]
            [models.user :as userm]
            [clojure.data.json :as json]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))
;;
(defroutes user-route (context "/api/user" []
  (GET "/" [id] (html [:h1 (str "Hello user " id)]))
  ;; todo: impl next, validate user
  (POST "/" [uname upass]
    (usersvc/create uname)
    (html [:h1 (str "Hello user " uname)]))
  (POST "/seaseme" [] (json/write-str {:isAuthenticated true}))
  (POST "/register" {body :body}
    (let [{
           uname "userName"
           pw "password"
           email "email"
           } body
          result (usersvc/create (userm/map->user {:name uname :password pw :email email}))]
      (if (= true result)
        (ring.util.response/response "")
        {:status  303
         :headers {}
         :body    (json/write-str result)})
        ))))
;; test wget
;; wget --post-data 'userName=diif&password=ddd&email=iv@lsl.c' localhost:3000/api/user/register

;; note: use slurp to cast objects to strings