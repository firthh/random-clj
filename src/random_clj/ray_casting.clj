(ns random-clj.ray-casting)

(defn get-indexed-elements [coll f]
  (keep-indexed #(if (f %1) %2) coll))

(defn list-points-to-pairs [list-points]
  (let [even-points (get-indexed-elements list-points even?)
        odd-points  (get-indexed-elements list-points odd?)]
    (interleave even-points odd-points)))

(defn point-in-polygon [polygon point]
  (map #() polygon))
