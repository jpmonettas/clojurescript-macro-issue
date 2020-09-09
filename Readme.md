# ClojureScript macro issue

Macroexpand inside a macro behaves differently when it is called from clojure and clojurescript.

## How to reproduce

Clone the repo and then :

```bash
# Run with clojure

clj -m foo.test

Result: (let* [and__5514__auto__ 1] (if and__5514__auto__ (clojure.core/and 2) and__5514__auto__))

```

```bash
# Run with clojurescript

clj -m cljs.main --target node --output-to main.js -c foo.test && node main.js

Result: (and 1 2)

```
