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
    (apply str (map-indexed (fn [idx itm]
               (int-to-char (mod (+ (char-to-int (nth message idx))
                                    (char-to-int (nth keyword (mod idx (count keyword))))) 26))) message)))
(defn decode [keyword message]
  (apply str (map-indexed (fn [idx itm]
               (int-to-char (mod (- (char-to-int (nth message idx))
                                    (char-to-int (nth keyword (mod idx (count keyword))))) 26))) message)))

(defn decipher [cipher message]
  "decypherme")
