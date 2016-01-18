(ns sample.core
  (:require [cljs.nodejs :as node]))


(defn thing-map [x] ; module fn
  {:thing x})


(defn init [] nil)        ; necessary
(set! *main-cli-fn* init) ; boilerplate


