(ns clj-workshop.parens-validator)

(defn count-parens
  "Return the number of parens in the vector"
  [depth par]
  (if (empty? par) depth
    (let [x (first par)
          tail (rest par)
          num-value (cond
                      (= x \() 1
                      (= x \)) -1
                      :otherwise 0)
          new-depth (+ depth num-value)]
      (if (> 0 new-depth) new-depth
        (count-parens new-depth tail)))))

(defn parens-balanced?
  "Returns true if parens in the provided string
  are balanced, false otherwise. Ignores any other
  characters."
  [s]
  (let [num-of-parens (count-parens 0 (vec s))]
    (cond
      (zero? num-of-parens) true
      :otherwise false)))
