(ns tasklist.controller.tasks
	(:require [compojure.core :refer [defroutes GET POST]]
			[clojure.string :as str]
			[ring.util.response :as ring]
			[tasklist.models.task :as task]
			[tasklist.views.task :as view]))

(defn index []
	(view/index (task/all)))

(defn create
	[taskname]
	(task/create taskname)
	(ring/redirect "/"))

(defroutes routes
	(GET "/" [] (index))
	(POST "/" [taskname] (create taskname)))