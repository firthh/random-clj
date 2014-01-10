(ns random-clj.ray-casting-test
  (:use midje.sweet)
  (:require [random-clj.ray-casting :refer :all]))


(def mock-basic-polygon
  [])

(facts "offeset collection"
  (fact "1"
    (offset-collection (range 20)) => [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 0])
  (fact "2"
    (offset-collection (range 10)) => [1 2 3 4 5 6 7 8 9 0])
  )

(facts "points to pairs"
  (fact "1"
    (points-to-pair {:x 1 :y 1} {:x 2 :y 2}) => {:x1 1 :y1 1 :x2 2 :y2 2})
  (fact "2"
    (points-to-pair {:x 3 :y 4} {:x 5 :y 6}) => {:x1 3 :y1 4 :x2 5 :y2 6})
  )

(future-facts "get indexed points"
  (fact "single element collection returns itself with even"
    (get-indexed-elements [1] even?) => [1])
  (fact "returns even indexed elements with larger collection"
    (get-indexed-elements [1 2 3] even?) => [1 3])
  (fact "returns odd indexed elements with larger collection"
    (get-indexed-elements [1 2 3] odd?) => [2]))

(facts "list to pair of points"
  (fact "single point should return nil"
    (list-points-to-pairs [[1 2]]) => [])
  (facts "two points should return one pair"
    (list-points-to-pairs [{:x 2 :y 3} {:x 3 :y 4}]) => [{:x1 2 :y1 3 :x2 3 :y2 4}])
  (facts "two points should return one pair"
    (list-points-to-pairs [{:x 1 :y 2} 
                           {:x 2 :y 3} 
                           {:x 3 :y 4}]) => [{:x1 1 :y1 2 :x2 2 :y2 3}
                                             {:x1 2 :y1 3 :x2 3 :y2 4}
                                             {:x1 3 :y1 4 :x2 1 :y2 2}])
  )

(future-facts "ray casting"
  (fact "1,1 is inside a square"
    (point-in-polygon mock-basic-polygon [1 1]) => true)
  (fact "34,3 is outside the same square"
    (point-in-polygon mock-basic-polygon [3 3]) => false)
  )

