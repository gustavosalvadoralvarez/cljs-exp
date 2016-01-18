(defproject cljs-ws "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2311"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]]

  :source-paths ["src"]

  :cljsbuild {
    :builds [{:id "cljs-ws"
              :source-paths ["src"]
              :compiler {
                :target :nodejs
                :output-to "cljs_ws.js"
                :output-dir "out"
                :optimizations :simple}}]})
