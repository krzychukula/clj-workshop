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

;; Atom - MOST POPULAR

(def x (atom 0))

(deref x)
@x

(reset! x 5)
@x
(deref x)

(swap! x inc)
@x
(deref x)

;; passing additional arguments
(swap! x + 10 5);;71 (+ x 10 5)
(deref x)

;; optimist locking
;; in case of conflict function in swap! can be called
;; multiple times!


(swap! x + 50)
@x
(deref x)



;; Agent - NOT popular

(def a (agent 0))
(deref a)

(send a inc)
(deref a)

(send a + 10)
(deref a)

(send a (fn [n] (Thread/sleep 5000) (* 10 n)))
(deref a)
;; deref is not blocking - you may see old value
@a
;; agents have queues of async actions


;; Ref
(def r (ref 100))
@r
(deref r)

#_(ref-set r 0) ;; error

;; transaction!
(dosync
 (ref-set r 1000)) ;; like reset for atom
@r
(deref r)

(dosync
 (alter r - 500)) ;; like swap! for atom
@r
(deref r)

(def r1 (ref 100))
(def r2 (ref 200))

(dosync
 (alter r1 - 50
  (send a + 10));; it is only send if the whole transaction passed
 (alter r2 + 50))
@r1
@r2

(deref r1)
(deref r2)


;;(def x 1) ;; for all threads

;; THREAD LOCAL

(def ^:dynamic x 1)
(future (println x))

(binding [x 5]
  (println x))

(future
  (binding [x 10]
    (Thread/sleep 5000)
    (println "t1" x)))

(future
  (binding [x 100]
    (Thread/sleep 500)
    (println "t2" x)))

(println x)

;; dynamic and binding are used for problematic things

