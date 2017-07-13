# Comparing performance of constructor dispatch methods

This project compares the performance of two forms of instantiation: calling `new` directly vs. dispatching to the `new`
method. I ran across this in a codebase I was reviewing and was curious whether there were any performance impacts.

The tests are contained in `com.jeremy_boyd.ConstructorDispatchBenchmark` and were run via the [Java Microbenchmark
Harness](http://openjdk.java.net/projects/code-tools/jmh/) (JMH). Also see [this tutorial](http://tutorials.jenkov.com/java-performance/jmh.html).
