(ns cljs_utils.highland
  (:require [[cljs.nodejs :as node]
             [cljs_utils.nutils :as nutils]]))

;; (sort-of)Idiomatic wrapper for highland.js node module
;; ----------------------------------------------------------------------------

;; Require highland

(def hland (nutils/nrequire "highland"))

;; Factory fns

(defn hland-method [method-name]
  "Returns a fn that applies its args to highland[method-name]"
  (fn [& args]
    (apply
      (get cljs_utils.highland/hland method-name)
      args)))

(defn |=> [& hland-methods]
  "Returns a highland.pipeline connecting its args"
  (.pipeline cljs_utils.highland/hland (array hland_methods)))

;; Highland methods

(def js-array> (hland-method "toArray"))

(def append> (hland-method "append"))

(def batch> (hland-method "batch"))

(def time-count-batch> (hland-method "batchWithTimeOrCount"))

(def collect> (hland-method "collect"))

(def compact> (hland-method "compact"))

(def consume> (hland-method "consume"))

(def debounce> (hland-method "debounce"))

(def doto> (hland-method "doto"))

(def drop> (hland-method "drop"))

(def errors> (hland-method "errors"))

(def filter> (hland-method "filter"))

(def find> (hland-method "find"))

(def find-where> (hland-method "findWhere"))

(def group> (hland-method "group"))

(def head> (hland-method "head"))

(def intersperse> (hland-method "intersperse"))

(def invoke> (hland-method "invoke"))

(def last> (hland-method "last"))

(def latest> (hland-method "latest"))

(def map> (hland-method "map"))

(def nf-call> (hland-method "nfcall"))

(def pick> (hland-method "pick"))

(def pick-by> (hland-method "pickBy"))

(def pluck> (hland-method "pluck"))

(def rate-limit> (hland-method "ratelimit"))

(def reduce> (hland-method "reduce"))

(def reduce-left> (hland-method "reducel"))

(def reject> (hland-method "reject"))

(def scan> (hland-method "scan"))

(def scan-left> (hland-method "scanl"))

(def slice> (hland-method "slice"))

(def sort> (hland-method "sort"))

(def sorty-by> (hland-method "sortBy"))

(def split> (hland-method "split"))

(def split-by> (hland-method "splitBy"))

(def stop-on-error> (hland-method "stopOnError"))

(def take> (hland-method "take"))

(def tap> (hland-method "tap"))

(def throttle> (hland-method "throttle"))

(def transduce> (hland-method "transduce"))

(def uniq> (hland-method "uniq"))

(def uniq-by> (hland-method "uniqBy"))

(def where> (hland-method "where"))

(def concat> (hland-method "concat"))

(def flat-filter> (hland-method "flatFilter"))

(def flat-map> (hland-method "flatMap"))

(def flatten> (hland-method "flatten"))

(def fork> (hland-method "fork"))

(def merge> (hland-method "merge"))

(def merge-with-limit> (hland-method "mergeWithLimit"))

(def observe> (hland-method "observe"))

(def otherwise> (hland-method "otherwise"))

(def parallel> (hland-method "parallel"))

(def sequence> (hland-method "sequence"))

(def series> (hland-method "series"))

(def through> (hland-method "through"))

(def zip> (hland-method "zip"))

(def zip-all> (hland-method "zipAll"))

(def zip-all-0> (hland-method "zipAll0"))

(def apply> (hland-method "apply"))

(def done> (hland-method "done"))

(def each> (hland-method "each"))

(def |> (hland-method "pipe"))

(def pull> (hland-method "pull"))

;; Utility fns

(defn _> [x]
  "Calls highland constructor with x and returns instance"
  (cljs_utils.highland/hland x))

(defn cljs> [x]
  "Takes a highland stream and returns a sequence of clojurescript data"
  (js->cljs (<js-array> x)))

(defn >? [x]
  "Returns true if x is a highland stream, false else"
  (get x "isStream"))

;; Necessary Boilerplate

(defn init [] nil)
(set! *main-cli-fn* init)


