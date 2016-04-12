(ns clj-workshop.func-prog
  (:require [clj-workshop.utils :refer :all]))

;; Anonymous functions

(fn [a]
  (+ a 5))

#(+ % 5)

(#(+ % 5) 5)

(fn [a1 a2 a3])

#(+ % %2 %3)

#(+ %1 %2 %3)

#(+ %5 %7)

;; Useful functions

(range 5)
(range 5 10)
(range 5 20 3)

;; don't do this at home (:
;; infinite range:
#_(range)

(reverse (range 5 10))

(take 10 (range 1000))
;; this one is safe
(take 10 (range))

;; drop returns lazy sequence as well
(drop 3 (range 10))

;; stops when predicate returns false
(take-while #(< % 10)
            (range 100))

(drop-while #(< % 10)
            (range 20))

;; pass filter if predicate is true
(filter even? (range 10))

(remove even? (range 10))


(some even? [1 2 3])
;; returns result of predicate that is truthy
(some (fn [a]
  (if (= a 2) a false)) [1 2 3])

(some even? [1 3 5])

(every? even? [1 2 3])

(every? even? [2 4])


(map even? (range 10))

(map nil? [1 nil true false])

(map inc [1 2 3])

;; keywards and symbols are functions
(map :type
     [{:name "John"}
      {:name "Joe"}])
;; (nil nil)

(map :name
     [{:name "John"}
      {:name "Joe"}])
;; ("John" "Joe")


(map (fn [a b]
       [a b])
     [:x :y]
     [1 2 3])
;; 3 will be ignored


(sort [2 4 1 6 7])
(sort-by :name
         [{:name "John"}
          {:name "Adam"}
          {:name "Ąaul"}])

(frequencies [1 2 3 2 1 1])
(group-by
 :count
 [{:n "a" :count 10}
  {:n "b" :count 100}
  {:n "c" :count 10}])

;; Threading macros

(sort
 (map
  str
  (filter
   even?
   (range 10))))

(as-> 10 it
      (range it)
      (filter even? it)
      (map str it)
      (sort it))

(it-> 10
      (range it)
      (filter even? it)
      (map str it)
      (sort it))

(->> 10
    (range)
    (filter even?)
    (map str)
    (sort))

;; Function composition

(def magic (comp inc *))

(magic 5 6)

;; Partial application

(def add-5 (partial + 5))
(add-5 10)
(add-5 1 3)

;; Reduce

(reduce
 (fn [acc x] (+ acc x))
 (range 10))
(reduce + 100 (range 10))

;; Sequential destructuring

(let [[x1 x2] [1 2 3]]
  (println x1 x2))

(let [[x & xs] [1 2 3]]
  (println x xs))

(let [[x1 x2 x3] [1 2]]
  (println x1 x2 x3))

(let [[x1 x2 :as xs] [1 2 3]]
  (println x1 x2)
  (println xs))

;; Map destructuring

(let [{a :a} {:a 1 :b 2}]
  (println a))

(let [{a :a :as m}
      {:a 1 :b 2}]
  (println a m))

(let [{:keys [a b] :as m}
      {:a 1, :b 2, :c 3}]
  (println a b m))

(let [{:keys [a b d] :or {a 0 d 4}}
      {:a 1, :b 2, :c 3}]
  (println a b d))

(defn configure [opts]
  (let [{:keys [volume bass treble]
         :or {volume 5 bass 3 treble 2}} opts]
    (println "Config" (keyed [volume bass treble]))))

(configure {:volume 1})

(defn configure' [{:keys [volume bass treble]
                   :or {volume 5 bass 3 treble 2}}]
  (println "Config" (keyed [volume bass treble])))

(configure' {:volume 1})

(defn configure'' [& {:keys [volume bass treble]
                      :or {volume 5 bass 3 treble 2}}]
  (println "Config" (keyed [volume bass treble])))

(configure'' :volume 1 :bass 7)
