(ns tasklist.models.dbmanager
	(:require [clojure.java.jdbc :as jdbc]
		[tasklist.models.task :as task]))

(defn table_exist? []
	(-> (jdbc/query task/mysql-db
		[( str "SELECT COUNT(*) from information_schema.tables WHERE table_name='tasks'")])
	first :count pos?))

(defn create_table []
	(jdbc/create-table-ddl
		:tasks
		[:taskname "varchar(255)" :primary :key]))