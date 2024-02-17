# Breadth Search
An implementation of a flexible and partially optimized breadth-first search mechanism in Clojure.

## Features

This library provides a generic mechanism to apply breadth-first search to any problem space by specifying a start state, goal state (or predicate), and a function to generate legal moves from any given state.

- Customizable state comparison function
- Optional debugging output
- Flexible goal specification

## Requirements

This project is built with [Leiningen](https://leiningen.org/), a tool for Clojure project management. Make sure you have Leiningen installed on your machine before proceeding.

## Installation

To use `breadth-search` in your own project, add the following dependency to your `project.clj` file:

```clojure
[org.clojars.cognesence/breadth-search "0.9.0"]
```

## Usage

Here is a basic example of how to use the `breadth-search` function:

```clojure
(ns your.namespace
  (:require [org.clojars.cognesence.breadth-search.core :refer [breadth-search]]))

(let [start-state ...
      goal-state ...
      legal-move-generator ...
      ]
  (breadth-search start-state goal-state legal-move-generator))
```

### Parameters

- `start`: The initial state of your problem.
- `goal`: A predicate function to determine if a given state is the goal or a specific state to reach.
- `lmg`: A function that takes a state and returns a list of legal next states.
- `compare`: (Optional) A function to compare two states for equality. Defaults to `=`.
- `debug`: (Optional) If true, prints debugging information.

## Contributing

We welcome contributions! Please feel free to submit pull requests or open issues to discuss new features or improvements.

## License

Copyright © 2017 Simon Lynch

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
