(ns random-clj.fizz-buzz)

(defn number-or-fizz-buzz [num]
  (if (= 0 (mod num 15))
    "fizzbuzz"
    (if (= 0 (mod num 3))
      "fizz"
      (if (= 0 (mod num 5))
        "buzz"
        num))))

(defn fizzbuzz [upper-bound]
  (map number-or-fizz-buzz (range 1 (inc upper-bound))))

(defn -main []
  (doall (map println (fizzbuzz 100))))
