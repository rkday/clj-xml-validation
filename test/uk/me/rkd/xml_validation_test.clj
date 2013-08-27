(ns uk.me.rkd.xml-validation-test
  (:require [clojure.test :refer :all]
            [uk.me.rkd.xml-validation :refer :all]))

(def validate (create-validation-fn "resources/example.xsd"))

(deftest obviously-wrong
  (testing "Validator fails on obviously incorrect XML"
    (is (= false (validate "<wrong>")))))

(deftest malformed
  (testing "Validator fails on malformed XML"
    (is (= false (validate "<wrong<")))))

(deftest obviously-right
  (testing "Validator succeeds on obviously correct XML"
    (is (= true (validate "<note><to></to><from></from><heading></heading><body></body></note>")))))

(deftest missing-element
  (testing "Validator fails on XML missing one element"
    (is (= false (validate "<note><to></to><heading></heading><body></body></note>")))))

(deftest added-element
  (testing "Validator fails on XML with a non-schema element"
    (is (= false (validate "<note><to></to><from></from><heading></heading><body></body><spurious/></note>")))))
