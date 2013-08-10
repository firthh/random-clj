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
