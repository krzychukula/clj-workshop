(ns clj-workshop.coll-contains)

(defn coll-contains?
  "Returns true if the provided coll contains the given x value"
  [coll x]
  (if (empty? coll) false
    (let [y (first coll)
          tail (rest coll)]
      (or (= x y) (coll-contains? tail x)))))


