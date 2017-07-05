(ns org.clojars.cognesence.breadth-search.core)

;; breadth first search mechanism
;; @args start start state
;; @args goal either a predicate to take a state determine if it is a goal
;;            or a state equal to the goal
;; @args LMG  legal move generator function which takes one state & returns
;;            a list of states
;; @args compare is a function which compares 2 states for equality,
;;            = is used by default
;; @args debug prints some information

(declare breadth-search-)

(defn breadth-search
  [start goal lmg & {:keys [debug compare]
                     :or {debug    false
                          compare  =    }}]
  (let [goal? (if (fn? goal)
                #(when (goal %) %)
                #(when (= % goal) %))
        ]
    ;; a daft check but required just in case
    (or (goal? start)
      (breadth-search- `((~start)) goal? lmg compare debug)
      )))


(defn breadth-search- [waiting goal? lmg compare debug]
  (let [member? (fn [lis x] (some (partial compare x) lis))
        visited #{}
        ]
    (when debug (println 'waiting= waiting 'visited= visited))
    (loop [waiting waiting
           visited visited
           ]
      (if (empty? waiting) nil
        (let [ [next & waiting] waiting
               [state & path] next
               visited? (partial member? visited)
               ]
          (if (visited? state)
            (recur waiting visited)
            (let [succs (remove visited? (lmg state))
                  g     (some goal? succs)
                  ]
              (if g (reverse (cons g next))
                (recur (concat waiting (map #(cons % next) succs))
                  (cons state visited) ))
              )))))))
              