(defn lev [w1 w2 counter]
(if (= 0 (count w1))
(+ (count w2) counter)
(if (= 0 (count w2))
(+ (count w1) counter)
(let [diff (if (= (first w1) (first w2)) 0 1)]
(min (lev (apply str (rest w1)) (apply str (rest w2)) (+ diff counter))
(lev w1 (apply str (rest w2)) (+ diff counter))
(lev (apply str (rest w1)) w2 (+ diff counter)))))))
