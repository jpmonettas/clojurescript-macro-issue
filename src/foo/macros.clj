(ns foo.macros)

(defmacro m [form]
  `(quote ~(macroexpand form)))
