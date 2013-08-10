(ns random-clj.lev-test
    (:use midje.sweet)
    (:require [random-clj.lev :refer :all]))

(facts "levensthein distance")
(fact "same words have a distance of zero"
      (lev "word" "word") => 0)
