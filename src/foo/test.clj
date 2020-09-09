(ns foo.test
  (:require  [foo.macros :refer [m]]))

(defn -main [& args]
  (println "Result:" (m (and 1 2))))
