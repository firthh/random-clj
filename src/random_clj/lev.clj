(ns random-clj.lev)

(defn str-rem [string]
  (apply str (rest string)))

(defn lev 
  ([w1 w2] (lev w1 w2 0))
  ([w1 w2 counter]
     (cond 
      (= 0 (count w1)) (+ (count w2) counter)
      (= 0 (count w2)) (+ (count w1) counter)
      :else (if (= (first w1) (first w2))  
              (lev (str-rem w1) (str-rem w2) counter)
              (min (lev  (str-rem w1)  (str-rem w2)  (inc counter))
                   (lev  w1            (str-rem w2)  (inc counter))
                   (lev  (str-rem w1)  w2            (inc counter)))
              )
      ))
  )

;;todo: add a new implementation using another version of the algorithm

(def lev2
"How I think it is implemented - we iterate through and build up a table of values
 Each value is calculated based off two things - 
     1. if the current letters are the same or different
     2. the value in the same? column (or to the left) in the row above")
