(ns tasklist.models.dbmanager
	(:require [clojure.java.jdbc :as jdbc]))
	
(def mysql_connection {:subprotocol "mysql"
	:subname "//localhost:3306/tasklist"
	:user "root"
	:password "florentino"})

(defn table_exist? []
	(-> (jdbc/query mysql_connection
		[( str "SELECT COUNT(*) from information_schema.tables"
				" WHERE table_name='tasks'")])
	first :count pos?))

(defn create_table []
	(jdbc/db-do-commands mysql_connection
		(jdbc/create-table-ddl
			:tasks
			[:title "varchar(255)" :primary :key]
			[:description "varchar(255)"]
			[:status "integer"]
		)
	)
)