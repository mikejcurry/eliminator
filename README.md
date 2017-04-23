# Eliminator

This is an implementation of a solution to https://en.wikipedia.org/wiki/Josephus_problem, as described there.

In order to run the tests associated with the project, simply type `sbt test`.

In order to run the application with custom parameters, type `sbt 'run n k'` where:
- n is the number of people in the circle, and
- k is the number of people to traverse while selecting the next person.
