(ns clj-workshop.concurrency-exe-test
  (:require [clj-workshop.concurrency-exe :as ut]
            [clojure.test :refer :all]))

#_(deftest multi-increment-test
  (is (= 4000 (ut/multi-increment 4 1000))))

#_(deftest bank-simulation
  (is (= 10000 (ut/bank-simulation 4 1000 7000 3000))))
