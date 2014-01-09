(ns random-clj.ray-casting-test
  (:use midje.sweet)
  (:require [random-clj.ray-casting :refer :all]))


(def mock-basic-polygon
  [])

(facts "get indexed points"
  (fact "single element collection returns itself with even"
    (get-indexed-elements [1] even?) => [1])
  (fact "returns even indexed elements with larger collection"
    (get-indexed-elements [1 2 3] even?) => [1 3])
  (fact "returns odd indexed elements with larger collection"
    (get-indexed-elements [1 2 3] odd?) => [2]))

(future-facts "list to pair of points"
  (fact "single point should return nil"
    (list-points-to-pairs [[1 1]]) => [])
  (facts "two points should return one pair"
    (list-points-to-pairs [[0 0] [1 1]]) => [[0 0 1 1]])
  )

(future-facts "ray casting"
  (fact "1,1 is inside a square"
    (point-in-polygon mock-basic-polygon [1 1]) => true)
  (fact "34,3 is outside the same square"
    (point-in-polygon mock-basic-polygon [3 3]) => false)
  )

