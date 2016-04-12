(ns clj-workshop.parens-validator-test
  (:require [clj-workshop.parens-validator :refer :all]
            [clj-workshop.test-utils :refer :all]
            [clojure.test :refer :all]))

(deftest parens-validation
  (with-redefs [reduce (unavailable-fn "reduce")
                map (unavailable-fn "reduce")
                filter (unavailable-fn "reduce")]
    (is (true? (parens-balanced? "((((( a )(b ( c(\n((()))))) e, f :g))))")))
    (is (false? (parens-balanced? "(((((()))()))")))
    (is (false? (parens-balanced? ")(")))
    (is (true? (parens-balanced? "")))))
