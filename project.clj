(defproject clojuristic "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [
                 [org.clojure/clojure "1.10.0"]
                 [com.novemberain/monger "3.1.0"]
                 ;[ring/ring-core "1.8.0"]
                 ;[javax.servlet/servlet-api "2.5"]
                 [compojure "1.6.1"]
                 [hiccup "1.0.5"]
                 [ring/ring-json "0.5.0"]
                 [org.clojure/data.json "1.0.0"]
                 [org.clojure/tools.logging "1.0.0"]
                 [org.clojure.typed/runtime.jvm "1.0.1"]
                 [reagent "0.10.0"]
                 [ring/ring-defaults "0.3.2"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler api.restful.base/app}
  :main ^:skip-aot clojuristic.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [org.clojure.typed/checker.jvm "1.0.1"]
                                  [ring/ring-mock "0.3.2"]]}})
