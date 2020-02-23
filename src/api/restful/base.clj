(ns api.restful.base
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [hiccupr.core :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

;;; defrest "url" "other mapping" (...code...)


(defroutes app-routes
           (GET "/:id" [id] [:h1 (str "Hello user " id )])
           (route/not-found "Not Found"))
(str "<h1>Hello user " id "</h1>")
(def app
  (wrap-defaults app-routes site-defaults))

