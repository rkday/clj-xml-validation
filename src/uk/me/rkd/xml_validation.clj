(ns uk.me.rkd.xml-validation)

(import 'javax.xml.XMLConstants)
(import 'org.xml.sax.SAXException)
(import 'javax.xml.validation.SchemaFactory)
(import 'java.io.File)
(import 'java.io.StringReader)
(import 'javax.xml.transform.stream.StreamSource)

(defn create-validation-fn [schema]
  (let [validator (.newValidator
      (.newSchema
       (SchemaFactory/newInstance XMLConstants/W3C_XML_SCHEMA_NS_URI)
       (StreamSource. (File. schema))
       ))]
    (fn [xmldoc]
      (try
        (.validate validator
                   (StreamSource. (StringReader. xmldoc)))
        true
        (catch SAXException e false)))))
