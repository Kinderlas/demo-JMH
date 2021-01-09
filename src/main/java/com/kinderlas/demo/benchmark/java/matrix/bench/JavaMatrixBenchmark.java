package com.kinderlas.demo.benchmark.java.matrix.bench;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.tuple.Pair;
import org.openjdk.jmh.annotations.*;

import com.kinderlas.demo.benchmark.java.matrix.data.AbstractMatrixData;
import com.kinderlas.demo.benchmark.java.matrix.data.ColtData;
import com.kinderlas.demo.benchmark.java.matrix.data.CommonMath3Data;
import com.kinderlas.demo.benchmark.java.matrix.data.EjmlData;
import com.kinderlas.demo.benchmark.java.matrix.data.JblasData;
import com.kinderlas.demo.benchmark.java.matrix.data.La4jData;
import com.kinderlas.demo.benchmark.java.matrix.data.Nd4jData;

import lombok.extern.slf4j.Slf4j;

@BenchmarkMode(Mode.SampleTime)
@Warmup(iterations = 3)
@Measurement(iterations = 2, time = 20, timeUnit = TimeUnit.SECONDS)
// @Threads(32)
@Fork(1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@State(Scope.Benchmark)
@Slf4j
public class JavaMatrixBenchmark {

    public static final int arraySize = 1000;

    @Param({"0", "1", "2", "3", "4", "5", "6"})
    private int n;

    @Param({"commonMath3", "colt", "ejml", "la4j", "nd4j", "jBlas"})
    private String toolName;

    public static final List<Pair<Integer, Integer>> shapes = List.of(
            Pair.of(100, 100),
            Pair.of(1000, 1000),
            Pair.of(965, 256),
            Pair.of(480, 256),
            Pair.of(360, 128),
            Pair.of(256, 128),
            Pair.of(128, 64)
    );

    private static final Map<String, AbstractMatrixData<?>> toolMap = new HashMap<>();
    static {
        toolMap.put("commonMath3", new CommonMath3Data(shapes));
        toolMap.put("nd4j", new Nd4jData(shapes));
        toolMap.put("colt", new ColtData(shapes));
        toolMap.put("la4j", new La4jData(shapes));
        toolMap.put("jBlas", new JblasData(shapes));
        toolMap.put("ejml", new EjmlData(shapes));
    }

    @Benchmark
    public void addBenchmark() {
        toolMap.get(toolName).randomAdd(shapes.get(n));
    }

    @Benchmark
    public void mulBenchmark() {
        toolMap.get(toolName).randomMul(shapes.get(n));
    }


}
