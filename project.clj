(defproject tasklist "0.1.0-SNAPSHOT"
	:description "Tasklist App"
	:url "https://github.com/ortegarenzy/tasklist-clojure"
	:license {
		:name "Eclipse Public License"
		:url "http://www.eclipse.org/legal/epl-v10.html"
	}
	:dependencies [[org.clojure/clojure "1.8.0"]
				[mysql/mysql-connector-java "5.1.25"]
				[org.clojure/java.jdbc "0.3.5"]
				[compojure "1.1.6"]
				[ring/ring-jetty-adapter "1.2.1"]
				[hiccup "1.0.4"]]
	:main tasklist.core)
