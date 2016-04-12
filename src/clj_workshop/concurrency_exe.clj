(ns clj-workshop.concurrency-exe
  (:require [clj-workshop.utils :refer :all]))

(defn multi-increment
  "Start threads-count threads and make each increment the shared number (with initial value 0) inc-count times.
  Return the value of the shared number"
  [threads-count inc-count]
  (unimplemented))

(defn bank-simulation
  "Start threads-count threads and make each execute txn-count transactions where random amount of money
  is transferred between two accounts.
  Returns the sum of money from both accounts"
  [threads-count txn-count account1-init-val account2-init-val]
  (unimplemented))
