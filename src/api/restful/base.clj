(ns api.restful.base
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.core :refer :all]
            [api.restful.user :refer :all]
            [ring.middleware.json :refer [wrap-json-body]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

;;; defrest "url" "other mapping" (...code...)


(defroutes app-routes
           ;(GET "/:id" [id] (html [:h1 (str "Hello user " id)]))
           (wrap-json-body user-route)
           (route/not-found "Not Found"))
;; todo: https://ring-clojure.github.io/ring/ring.middleware.cookies.html cookie implementation
;; todo: provide a function to return some base routes for common tasks, e.g.: get<model>ById

(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))

;; todo: implement middleware here and redirect to /login if no login token specified
;; 	or if token exists, validate and create a user profile
