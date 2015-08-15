(ns colinkahn.ui.scroll-list-test
  (:require [colinkahn.ui.scroll-list
             :refer [positions transform]]
            [cemerick.cljs.test :as t])
  (:require-macros [cemerick.cljs.test
                    :refer [is deftest testing are]]))

(enable-console-print!)

(deftest scroll-list-positions
  (testing "Returns correct positions"
    (is (= (positions 3 1 6 0) [[0 0] [1 1] [2 2] [3 3]]))
    (is (= (positions 3 1 6 3) [[4 0] [5 1] [3 3]]))))

(deftest scroll-list-transform
  (testing "Tranform styles"
    (is (= (transform 2 10) {"transform" "translate(0px,20px)"
                              "webkitTransform" "translate(0px,20px)"
                              "mozTransform" "translate(0px,20px)"
                              "msTransform" "translate(0px,20px)"
                              "oTransform" "translate(0px,20px)"}))))
