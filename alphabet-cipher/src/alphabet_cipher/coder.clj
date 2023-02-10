(ns alphabet-cipher.coder)

;; Función para
(defn char-to-int [ch] (- (int ch) 97))

;; función inversa de la anterior
(defn int-to-char [idx] (char (+ idx 97)))


(defn encode [keyword message]
  (str map-indexed #() message))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")
