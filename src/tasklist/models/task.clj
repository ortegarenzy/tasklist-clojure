(ns tasklist.models.task
	(:require [clojure.java.jdbc :as jdbc]))

(def mysql-db {:subprotocol "mysql"
	:subname "//localhost:3306/tasklist"
	:user "root"
	:password "florentino"})

(defn all []
  (jdbc/query mysql-db ["SELECT * FROM tasks"]))

(defn create [name]
	(jdbc/insert! mysql-db :tasks {:taskname name }))