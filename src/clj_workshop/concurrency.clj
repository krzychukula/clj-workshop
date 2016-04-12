(ns clj-workshop.concurrency)

;; Future
(let [f1 (future
           (println "f1")
           (Thread/sleep 5000)
           10)
      f2 (future
           (println "f2")
           (Thread/sleep 5000)
           20)]
  (println (deref f1)
           (deref f2)
           @f1
           @f2))

;; Atom

(def x (atom 0))

(deref x)
@x

(reset! x 5)
@x

(swap! x inc)
@x

(swap! x + 50)
@x

;; Agent

(def a (agent 0))
@a

(send a inc)
@a

(send a + 10)
@a

(send a (fn [n] (Thread/sleep 5000) (* 10 n)))
@a

;; Ref
(def r (ref 100))
@r

#_(ref-set r 0)

(dosync
 (ref-set r 1000))
@r

(dosync
 (alter r - 500))
@r

(def r1 (ref 100))
(def r2 (ref 200))

(dosync
 (alter r1 - 50)
 (alter r2 + 50))
@r1
@r2
