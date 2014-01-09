(ns random-clj.fizz-buzz-test
  (:use midje.sweet)
  (:require [random-clj.fizz-buzz :refer :all]))

(facts "fizz-buzz"
  (fact "3rd element is fizz"
    (get (vec (fizzbuzz 100)) 2) => "fizz")
  (fact "6th element is fizz"
    (get (vec (fizzbuzz 100)) 5) => "fizz")
  (fact "5th element is buzz"
    (get (vec (fizzbuzz 100)) 4) => "buzz")
  (fact "10th element is buzz"
    (get (vec (fizzbuzz 100)) 9) => "buzz")
  (fact "15th element is fizzbuzz"
    (get (vec (fizzbuzz 100)) 14) => "fizzbuzz")
  (fact "30th element is fizzbuzz"
    (get (vec (fizzbuzz 100)) 29) => "fizzbuzz")
)
