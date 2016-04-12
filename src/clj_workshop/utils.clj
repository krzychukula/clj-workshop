(ns clj-workshop.utils)

(defn unimplemented
  []
  (throw (ex-info "Implement me" {})))

(defmacro it->
  [expr & forms]
  `(as-> ~expr ~'it ~@forms))

(defmacro it'->
  [expr & forms]
  `(let [~'it ~expr
         ~@(interleave (repeat 'it) forms)]
     ~'it))

(defmacro keyed
  [vars]
  (into
   {}
   (for [v vars]
     [(keyword v) v])))
