(ns cljs_utils.nutils
  (:require [cljs.nodejs :as node]))



; Macro: node\require
; ----------------------------------------------------------------------------
(defmacro nrequire [name-string]
  "Transforms name-string into the value returned by (node/require name-string)"
  (list 'cljs.nodejs/require name-string))



; Property and method check
; ----------------------------------------------------------------------------
(def property? [x p]
  "Return true if x has ownProperty p, else false"
  (.hasOwnProperty x p))


(def method? [x p]
  "Return true if x has ownProperty p and x.p is a js/Function, else false"
  (and (.hasOwnProperty x p) (fn? (get x p))))


; Macro: if-method
; ----------------------------------------------------------------------------
(defmacro if-method [x p]
  "If x has method p, return a fn that applies x.p, else throw a js/Error"
  (list 'fn '[& rest]
        (list 'if
              (list 'cljs_utils.nutils/method? x p)
              (list 'apply '(list get x p) '(cons x rest))
              (list 'throw (list 'js/Error. '"x is not a stream")))))


; Reverse apply
; ----------------------------------------------------------------------------

(defn rapply [args, f] (apply f args))

(defn init [] nil)        ; necessary
(set! *main-cli-fn* init) ; boilerplate


