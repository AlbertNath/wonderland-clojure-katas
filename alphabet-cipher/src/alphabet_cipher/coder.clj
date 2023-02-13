(ns alphabet-cipher.coder)

(defn char-to-int
  "Función para convertir un carácter  en representación decimal ASCII. Restamos
  97 pues el alfbeto minúsuclo empieza en este índice."
  [ch]  (- (int ch) 97))

;; función inversa de la anterior
(defn int-to-char
  "Función inversa a la anterior"
  [idx] (char (+ idx 97)))

(defn encode
  "La idea  es iterar por la  cadena a cifrar  y usar los carácteres  ASCII como
  índices; el  cruce entre  el valor del  carácter en `idx`  del `mensaje`  y el
  valor del que está en `idx` de la  `keyword` nos dice cuántas veces se rotó el
  alfabeto entonces su suma módulo 26 (número  de letras en el alfabeto + 1) nos
  da el índice del elemento que corresponde al cifrado."
  [keyword message]
  (apply str (map-indexed (fn [idx _]
                            (int-to-char (mod (+ (char-to-int (nth message idx))
                                                 (char-to-int (nth keyword (mod idx (count keyword))))) 26))) message)))
(defn decode
  "Al ser la  función inversa de la  anterior basta, en vez de  sumar, restar al
  valor  del carácter  en `idx`  de `keyword`  al valor  en el  mismo índice  en
  `message`."
  [keyword message]
  (apply str (map-indexed (fn [idx _]
                            (int-to-char (mod (- (char-to-int (nth message idx))
                                                 (char-to-int (nth keyword (mod idx (count keyword))))) 26))) message)))

(defn decipher
  "La fórmula  que nos  da el  carácter de la  `keyword` en  el índice  `idx` es
  $keyword[idx] = ((26 - message[idx]) +  cipher[idx] mod 26)$. Se deduce de que
  la función  inversa de `mod` es  $a + x =  0 mod m$ (aunque  probablemente hay
  formas más elegantes)."
  [cipher message]
  (apply str (distinct (apply str (map-indexed (fn [idx _]
                                 (int-to-char (mod (+ (- 26 (char-to-int (nth message idx)))
                                                      (char-to-int (nth cipher idx))) 26))) message)))))
(decipher "opkyfipmfmwcvqoklyhxywgeecpvhelzg" "thequickbrownfoxjumpsoveralazydog")
