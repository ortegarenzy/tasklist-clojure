(ns tasklist.util.response
	(:require [ring.util.response :as ring_response]))

(defn send_response [body]
	(ring_response/response body))

(defn send_ok []
	(send_response {:status "ok"}))
