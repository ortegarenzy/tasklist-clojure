(ns tasklist.views.task
	(:require [tasklist.views.container :as container]
		[hiccup.core :refer [h]]
		[hiccup.form :as form]))

(defn task-form []
	[:div {:id "task-form"}
		(form/form-to [:post "/"]
		[:div {:class "row"}
			(form/label "task" "Enter a new task")
		]
		[:div {:class "row"}
			(form/text-field "taskname")
		]
		[:div {:class "row"}
			(form/submit-button {:class "btn" } "SUBMIT")
		]
	)])

(defn display-task [tasks]
	[:div {:class "tasks"}
	[:h2 "List of Tasks"]
	(map
		(fn [task] [:h3 {:class "task"} (h (:taskname task))])
	tasks)])

(defn index[tasks]
	(container/common_page "Task Manager"
				[:div {:class "block form"}
					(task-form)
				]
				[:div {:class "block result"}
					(display-task tasks)
				]
	))