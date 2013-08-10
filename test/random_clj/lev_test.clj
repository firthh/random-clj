(ns random-clj.lev-test
    (:use midje.sweet)
    (:require [random-clj.lev :refer :all]))

(facts "levensthein distance"
       (fact "same words have a distance of zero"
             (lev "word" "word") => 0
             (lev "new1" "new1") => 0
             )
       (fact "words with 1 character different"
             (fact "handles extra character at the end"
                   (lev "word" "words") => 1)
             (fact "handles new character in the middle"
                   (lev "new" "neaw") => 1)
             (fact "handles a missing character"
                   (lev "hello" "helo") => 1)
             (fact "handles a duplicate character"
                   (lev "hello" "heello") => 1)
             )
       (fact "words with 2 characters different"
             (lev "qwerty" "erty") => 2
             (lev "asdfghjkl" "asdqghjl") => 2
             )
       (fact "long words"
             (lev "qwertyuiopasdfghjklzxcvbnm1234567890" 
                  "qwertyuiopasdfghjklzxcvbnm0987654321") => 10)

       )
        
