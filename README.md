# colinkahn.ui.scroll-list

Utility methods for performant scroll lists.

## Usage

```css
.scrollList__container {
  position: relative;
  overflow-y: scroll;
  height: 200px;
}

.scrollList__viewport {
  height: 4000px;
}

.scrollList__item {
  height: 20px;
  position: absolute;
}
```

```cljs
(ns example
  (:require [colinkahn.ui.scroll-list :as s]
            [reagent.core :as reagent :refer [atom]]))

(def val (atom 0))

(defn scroll-list []
  (let [scroll-top @val
        positions (s/positions 200 20 1000 scroll-top)
  [:div.scrollList__container
   {:on-scroll #(reset! val (.. e -target -scrollTop)}
    [:div.scrollList__viewport
    (for [[i k] positions]
      [:div.scrollList__item {:key k
                              :style (s/transform i 20)}
       i])]])
```

## License

Copyright © 2015 Colin Kahn

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
