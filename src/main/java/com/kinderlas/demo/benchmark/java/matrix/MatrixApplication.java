package com.kinderlas.demo.benchmark.java.matrix;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.kinderlas.demo.benchmark.java.matrix.bench.JavaMatrixBenchmark;

public class MatrixApplication {

    public static void main(String[] args) throws RunnerException {

        Options options = new OptionsBuilder()
                .include(JavaMatrixBenchmark.class.getSimpleName())
                .output("/opt/javaMatrixBenchmark.log." + LocalDateTime.now()
                        .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))
                .build();
        new Runner(options).run();

    }

}
