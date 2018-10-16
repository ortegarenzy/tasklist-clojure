(ns tasklist.views.home
	(:require [tasklist.views.container :as container]
		[hiccup.core :refer [h]]
	)
)

(defn list-tasks [tasks]
	[:div {:class "list-tasks"}
		[:ul
			(map
				(fn [task]
					[:li {:class "list"}
						[:div {:class "content-holder"}
							[:h2 (h (:title task))] 
							[:p (h (:description task))]
						]
						[:div {:class "content-holder"}
							[:div {:class "icon"} [:i {:class "fa fa-check"}] ]
							[:div {:class "icon"} [:i {:class "fa fa-trash"}] ]
						]
						[:div {:class "clear"}]
					])
			tasks)
		]
	]
)

(defn render[tasks]
	(container/common_page "Task Manager"
		[:div {:class "block"}
			[:a {:href "/" :class "btn" } "NEW"]
		]
		[:div {:class "block"}
			(list-tasks tasks)
		]
	)
)