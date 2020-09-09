(ns foo.macros
  (:require [cljs.analyzer :as ana]))

(def ^:dynamic *environment*)


(defn target-from-env [env]
  (if (contains? env :js-globals)
    :cljs
    :clj))

(defn hacked-macroexpand-1 [form]
  ((case (target-from-env *environment*)
     :cljs (partial ana/macroexpand-1 *environment*)
     :clj  macroexpand) form))

(defn hacked-macroexpand [form]
  (let [ex (hacked-macroexpand-1 form)]
      (if (identical? ex form)
        form
        (hacked-macroexpand ex))))

(defmacro m [form]
  (binding [*environment* &env]
    `(quote ~(hacked-macroexpand form))))
