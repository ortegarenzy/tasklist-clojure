(ns tasklist.core
	(:require
			[compojure.core :refer [defroutes]]
			[ring.adapter.jetty :as ring]
			[compojure.route :as route]
			[compojure.handler :as handler]
			[tasklist.models.dbmanager :as manager]
			[tasklist.controller.tasks :as tasks])
	(:gen-class))

(defroutes routes
	tasks/routes
	(route/resources "/"))

(def application (handler/site routes))

(defn start [port]
  (ring/run-jetty application {:port port }))

(defn -main []
	(manager/create_table)
	(let [port (Integer. (or (System/getenv "PORT") "8080"))]
    (start port)))
