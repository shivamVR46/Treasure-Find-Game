
(println "This is my challenge :")
(println )

(defn showMap[]
  (def str1 (slurp "map.txt"))
  (def c(clojure.string/split-lines str1 ))
  (def d (clojure.string/split (get c 0) #""))
  ;(println (count d))
  (println str1)
  (println ))


(defn openFile [] 
  (def a  (with-open  [rdr (clojure.java.io/reader "map.txt")]
    (to-array-2d (line-seq rdr)))))

    (println)
   
    (def halt 100)


      (defn recurse [i j m n l1 l2 ]

      ;(println i j)

      (if (= (str (aget a i j)) "@")
      (do
        ;(aset a i j "@")
        (def halt 101)
      ))

        
      (def f1  0)
      (def f2  0)
      (def f3  0)
      (def f4  0)

      
      (if (< (+ j 1) l2)
        (if (not (= (str (aget a i (+ j 1))) "#"))
         (if (not (and (= i m) (= (+ j 1) n)))
         (if (= halt 100)
           (do
           ;(println "In 1st")
           (recurse i (+ j 1) i j l1 l2 )
            (def f4 1)
            (if (= (str (aget a i (+ j 1))) "+")
                (def f4 0)))))))

      (if (>= (- j 1) 0)
       (if (not (= (str (aget a i (- j 1))) "#")) 
        (if (not (and (= i m)  (= (- j 1) n)))
        (if (= halt 100)
            (do
            ;(println "In 2nd")
               (recurse i (- j 1) i j l1 l2 )
               (def f2 1)
                (if (= (str (aget a i (- j 1))) "+")
                    (def f2 0)))))))

      (if (< (+ i 1) l1) 
        (if (not (= (str (aget a (+ i 1) j)) "#")) 
          (if (not (and (= (+ i 1) m) (= j n)))
          (if (= halt 100)
                (do
                ;(println "In 3rd")
                 (recurse (+ i 1) j i j l1 l2 )
                (def f1 1)
                (if (= (str (aget a (+ i 1) j)) "+")
                    (def f1 0)))))))
            

      (if (>= (- i 1) 0)
        (if (not (= (str (aget a (- i 1) j)) "#"))
         (if (not (and (= (- i 1) m) (= j n)))
         (if (= halt 100)
          (do
          ;(println "In 4th")
           (recurse (- i 1) j i j l1 l2)
            (def f3 1)
            (if (= (str (aget a (- i 1) j)) "+")
                (def f3 0)))))))
      

         (if (= f1 0)
          (if (= f2 0)
           (if (= f3 0)
            (if (= f4 0)
              (if (= halt 100)
             (aset a i j "!")
             (aset a i j "+")))))))

      
(showMap)
(openFile)
(def l1 (count a))
(def la (int l1))
(def l2 (count d))
(def ld (int l2))
(println)

(println "Path to Treasure  : ")
(println)
(recurse 0 0 0 0 la ld)

      
    (loop [i 0]
      (when (< i la)
    (loop [j 0]
      (when (< j ld)
        (print (aget a i j))
      (recur (+ j 1))))
        (println)
        (recur (+ i 1))))