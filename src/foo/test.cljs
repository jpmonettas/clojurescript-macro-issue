(ns foo.test
  (:require-macros  [foo.macros :refer [m]]))

(println "Result:" (m (and 1 2)))
