(ns random-clj.lev)

(defmulti leven 
  (fn [w1 w2 counter] 
    (if (= 0 (count w1))
      :W1
      (if (= 0 (count w2))
        :W2
	:None))))

(defmethod leven :W2 [w1 w2 counter]
	   (+ counter (count w1)))
(defmethod leven :W1 [w1 w2 counter]
	   (+ counter (count w2)))
(defmethod leven :None [w1 w2 counter]
  (let [counter' (if (= (first w1) (first w2)) 
       		     counter 
		     (inc counter))]
    (min (leven (apply str (rest w1)) (apply str (rest w2)) counter')
         (leven w1 (apply str (rest w2)) counter')
         (leven (apply str (rest w1)) w2 counter'))))




(defn lev 
  ([w1 w2] (lev w1 w2 0))
  ([w1 w2 counter]
  (cond 
    (= 0 (count w1)) (+ (count w2) counter)
    (= 0 (count w2)) (+ (count w1) counter)
    :else (let [diff (if (= (first w1) (first w2)) 0 1)]
          (min (lev (apply str (rest w1)) (apply str (rest w2)) (+ diff counter))
               (lev w1 (apply str (rest w2)) (+ diff counter))
               (lev (apply str (rest w1)) w2 (+ diff counter)))
          )))
  )
