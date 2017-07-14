# Comparing performance of constructor dispatch methods

This project compares the performance of two forms of instantiation: calling `new` directly vs. dispatching to the `new`
method. I ran across this in a codebase I was reviewing and was curious whether there were any performance impacts.

The tests are contained in `com.jeremy_boyd.ConstructorDispatchBenchmark` and were run via the [Java Microbenchmark
Harness](http://openjdk.java.net/projects/code-tools/jmh/) (JMH). Also see [this tutorial](http://tutorials.jenkov.com/java-performance/jmh.html).

To run this on your own machine, do the following:

    make clean install
    java -jar target/benchmarks.jar

# Results

Below are the results of executing the included `benchmarks.jar` on a late 2013 MacBook Pro with a 2.3 GHz i7 and 16GB
of RAM.

    Benchmark                                                                                     Mode      Cnt         Score        Error  Units
    ConstructorDispatchBenchmark.callNewForDummyClass                                            thrpt      200  25126236.367 ± 115781.201  ops/s
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass                                      thrpt      200  25217431.476 ±  67191.732  ops/s
    ConstructorDispatchBenchmark.callNewForDummyClass                                             avgt      200        ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass                                       avgt      200        ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass                                           sample  5929885        ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass:callNewForDummyClass·p0.00                sample                 ≈ 10⁻⁹                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass:callNewForDummyClass·p0.50                sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass:callNewForDummyClass·p0.90                sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass:callNewForDummyClass·p0.95                sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass:callNewForDummyClass·p0.99                sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass:callNewForDummyClass·p0.999               sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass:callNewForDummyClass·p0.9999              sample                 ≈ 10⁻⁵                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass:callNewForDummyClass·p1.00                sample                  0.001                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass                                     sample  6317981        ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass:dispatchToNewForDummyClass·p0.00    sample                 ≈ 10⁻⁹                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass:dispatchToNewForDummyClass·p0.50    sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass:dispatchToNewForDummyClass·p0.90    sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass:dispatchToNewForDummyClass·p0.95    sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass:dispatchToNewForDummyClass·p0.99    sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass:dispatchToNewForDummyClass·p0.999   sample                 ≈ 10⁻⁷                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass:dispatchToNewForDummyClass·p0.9999  sample                 ≈ 10⁻⁵                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass:dispatchToNewForDummyClass·p1.00    sample                  0.001                s/op
    ConstructorDispatchBenchmark.callNewForDummyClass                                               ss       10        ≈ 10⁻⁴                s/op
    ConstructorDispatchBenchmark.dispatchToNewForDummyClass                                         ss       10         0.001 ±      0.001   s/op

As you can see, the results are nearly within the margin of error of each other.
