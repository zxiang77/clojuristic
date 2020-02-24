(ns api.restful.base
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccup.core :refer :all]
            [api.restful.user :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

;;; defrest "url" "other mapping" (...code...)


(defroutes app-routes
           ;(GET "/:id" [id] (html [:h1 (str "Hello user " id)]))
           user-route
           (route/not-found "Not Found"))

;; todo: provide a function to return some base routes for common tasks, e.g.: get<model>ById
(def app
  (wrap-defaults app-routes (assoc-in site-defaults [:security :anti-forgery] false)))
