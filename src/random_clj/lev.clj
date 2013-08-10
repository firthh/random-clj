(ns random-clj.lev)

;; (defmulti leven 
;;   (fn [w1 w2 counter] 
;;     (if (= 0 (count w1))
;;       :W1
;;       (if (= 0 (count w2))
;;         :W2
;; 	:None))))

;; (defmethod leven :W2 [w1 w2 counter]
;; 	   (+ counter (count w1)))
;; (defmethod leven :W1 [w1 w2 counter]
;; 	   (+ counter (count w2)))
;; (defmethod leven :None [w1 w2 counter]
;;   (let [counter' (if (= (first w1) (first w2)) 
;;        		     counter 
;; 		     (inc counter))]
;;     (min (leven (apply str (rest w1)) (apply str (rest w2)) counter')
;;          (leven w1 (apply str (rest w2)) counter')
;;          (leven (apply str (rest w1)) w2 counter'))))


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
