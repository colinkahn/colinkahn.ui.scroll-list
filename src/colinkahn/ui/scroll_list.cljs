(ns colinkahn.ui.scroll-list)

(defn floor [x]
  (int (.floor js/Math x)))

(def positions
  (memoize
    (fn [container-height item-height item-count scroll-top]
      (let [start-index (-> scroll-top (/ item-height) floor)
            reusable-count (-> container-height (/ item-height) floor inc)
            end-index (-> start-index (+ reusable-count) dec (min (dec item-count)))]
        (sort-by peek
                 (loop [item-index start-index
                        positions (transient [])]
                   (if (<= item-index end-index)
                     (recur (inc item-index)
                            (conj! positions [item-index
                                              (mod item-index reusable-count)]))
                     (persistent! positions))))))))

(def transform
  (memoize (fn [i h]
             (let [t (str "translate(0px," (* i h) "px)")]
               {"transform" t
                "webkitTransform" t
                "mozTransform" t
                "msTransform" t
                "oTransform" t}))))
