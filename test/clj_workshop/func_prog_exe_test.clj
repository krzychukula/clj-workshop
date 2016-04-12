(ns clj-workshop.func-prog-exe-test
  (:require [clj-workshop.func-prog-exe :as ut]
            [clojure.test :refer :all]))

(def candidates
  [{:id 1
    :name "John Doe"
    :rating 7}
   {:id 2
    :name "Adam Smith"
    :rating 2}
   {:id 3
    :name "Julia Jones"
    :rating 9}])

(def primes-168 [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997])

(deftest count-chars-test
  (is (= 5 (ut/count-chars "abracadabra" \a)))
  (is (= 6 (ut/count-chars "abracadabraa" \a)))
  (is (= 0 (ut/count-chars "" \a)))
  (is (= 0 (ut/count-chars nil \a))))

(deftest candidate-names-test
  (is (= ["John Doe" "Adam Smith" "Julia Jones"] (ut/candidate-names candidates))))

(deftest candidates-with-minimum-rating-test
   (is (= [{:id 3 :name "Julia Jones" :rating 9}]
          (ut/candidates-with-minimum-rating 8 candidates))))

#_(deftest palindrome-test
   (is (true? (ut/palindrome? "kajak")))
   (is (true? (ut/palindrome? "kobylamamalybok")))
   (is (true? (ut/palindrome? [1 2 3 2 1])))
   (is (false? (ut/palindrome? [1 2])))
   (is (false? (ut/palindrome? "palindrom?"))))

#_(deftest count-palindromes-test
   (is (= 1 (ut/count-palindromes 0 1)))
   (is (= 199 (ut/count-palindromes 0 10000))))

#_(deftest primes-test
    (is (= primes-168 (take 168 (ut/primes)))))

#_(deftest flip-flop-test
   (is (= [2 2 4 4 6 6] (ut/flip-flop [1 2 3 4 5 6])))
   (is (= [2] (ut/flip-flop [1])))
   (is (= [] (ut/flip-flop []))))

#_(deftest munge-candidate-name-test
   (is (= "EOD NHOJ" (ut/mungle-candidate-name {:id 1 :name "John Doe"}))))

#_(deftest select-keys-test
   (is (= #{1 3} (into #{} (ut/select-values {:a 1 :b 2 :c 3} [:a :c])))))

#_(deftest rcomp-test
   (is (= 3 ((ut/rcomp + inc) 3 3))))

#_(deftest power-test
   (is (= 9 (ut/power 3 2))))

#_(deftest range-sum-test
   (is (= 4950 (ut/range-sum 100))))

#_(deftest rating-avg-test
   (is (= 6 (ut/rating-avg candidates))))

#_(deftest distance-tuple-test
   (is (= 10 (ut/distance-tuple [2 2] [10 8]))))

#_(deftest distance-map-test
   (is (= 10 (ut/distance-map {:x 2 :y 2} {:x 10 :y 8}))))
