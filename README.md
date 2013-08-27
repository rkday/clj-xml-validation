# uk.me.rkd.xml-validation

A Clojure library designed to wrap the Java libraries for XML schema validation. create-validation-fn takes a schema, and returns a function that takes an XML string and returns true (if the string is valid according to the schema) or false.

## Usage

```
(require '[uk.me.rkd.xml-validation :as xmlv])
(def is-valid-xml? (xmlv/create-validation-fn "resources/example.xsd"))
(is-valid-xml? "<foo><bar/></foo>")
```

## License

Copyright © 2013 Rob Day

Distributed under the Eclipse Public License, the same as Clojure.
