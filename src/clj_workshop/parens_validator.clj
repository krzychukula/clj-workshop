(ns clj-workshop.parens-validator)

(defn count-parens
  "Return the number of parens in the vector"
  [par]
  (if (empty? par) 0
    (let [x (first par)
          tail (rest par)
          num-value (cond
                      (= x \() 1
                      (= x \)) -1
                      :otherwise 0)]
      (+ num-value (count-parens tail)))))

(defn parens-balanced?
  "Returns true if parens in the provided string
  are balanced, false otherwise. Ignores any other
  characters."
  [s]
  (let [num-of-parens (count-parens (vec s))]
    (cond
      (zero? num-of-parens) true
      :otherwise false)))
