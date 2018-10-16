(ns tasklist.controller.tasks
	(:require [compojure.core :refer [defroutes GET POST DELETE]]
			[clojure.string :as str]
			[tasklist.models.task :as task]
			[tasklist.views.home :as home]
			[tasklist.util.response :as response]
			[tasklist.views.task :as view]))

(defn index []
	(home/render (task/all)))

(defn create
	[taskname]
	(task/create taskname))

(defn save_task [request]
	(let [title (get-in request [:body :title]) description (get-in request [:body :description])]
	(task/create title description 0)
	(response/send_ok)))

(defn delete_task [title]
	(task/delete title)
	(response/send_ok)
)

(defroutes routes
	(GET "/" [] (index))
	(DELETE "/task" [title] (delete_task title))
	(POST "/" request (save_task request)))