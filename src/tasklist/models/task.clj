(ns tasklist.models.task
	(:require [clojure.java.jdbc :as jdbc]
		[tasklist.models.dbmanager :as manager]))

(defn all []
  (jdbc/query manager/mysql_connection ["SELECT * FROM tasks"]))

(defn create [title, description, status]
	(jdbc/insert! manager/mysql_connection :tasks {:title title :description description :status status }))
(defn delete [title]
	(jdbc/delete! manager/mysql_connection :tasks ["title = ?" title]))