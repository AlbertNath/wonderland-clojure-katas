(ns alphabet-cipher.coder)

;; Función para
(defn char-to-int
  "Función para convertir un carácter en
  representación decimal ASCII. Restamos 97
  pues el alfbeto minúsuclo empieza en este
  índice."
  [ch]  (- (int ch) 97))

;; función inversa de la anterior
(defn int-to-char
  "Función inversa a la anterior"
  [idx] (char (+ idx 97)))


(defn encode [keyword message]
  (str map-indexed #() message))

(defn test-map [word, key]
  (str map-indexed #((int-to-char ((char-to-int (nth word %1)) +
                                   (char-to-int (nth key (mod %1 (count key))))))) word))

(defn decode [keyword message]
  "decodeme")

(defn decipher [cipher message]
  "decypherme")
