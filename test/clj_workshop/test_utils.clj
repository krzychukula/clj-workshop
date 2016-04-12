(ns clj-workshop.test-utils)

(defn unavailable-fn
  [name]
  (fn [& _] (throw (ex-info (str name " cannot be used in the solution") {}))))
