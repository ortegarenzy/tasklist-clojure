(ns tasklist.views.container
	(:require [hiccup.page :as page]))

(defn common_page [title & body]
	(page/html5
	[:head
		[:meta {:charset "utf-8"}]
		[:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
		[:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
		[:title title]
		(page/include-css "http://fonts.googleapis.com/css?family=VT323")
		(page/include-css "/css/style.css")
	]
	[:body
		[:div {:id "content" :class "container"}
			[:h1 "Task Manager"]
			body
		]
	]))
