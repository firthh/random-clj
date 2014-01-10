(ns random-clj.ray-casting)

(defn get-indexed-elements [coll f]
  (keep-indexed #(if (f %1) %2) coll))

(defn points-to-pair [point-one point-two]
  {
   :x1 (:x point-one)
   :y1 (:y point-one)
   :x2 (:x point-two)
   :y2 (:y point-two)
   })

(defn offset-collection [coll]
  (conj (vec (rest coll)) (first coll))  
)


(defn list-points-to-pairs 
  [collection]
  (if (> (count collection) 2)
    (map points-to-pair collection (offset-collection collection))
    (if (> (count collection) 1)
      [(apply points-to-pair collection)]
      []))
  )

(defn point-in-polygon [polygon point]
  (map #() polygon))
