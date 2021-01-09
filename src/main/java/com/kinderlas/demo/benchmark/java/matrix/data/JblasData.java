
package com.kinderlas.demo.benchmark.java.matrix.data;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.jblas.DoubleMatrix;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class JblasData extends AbstractMatrixData<DoubleMatrix>{

    public JblasData(List<Pair<Integer, Integer>> shapes) {
        super(shapes);
    }

    @Override
    DoubleMatrix createMatrix(Integer r, Integer c) {
        return DoubleMatrix.rand(r, c);
    }

    @Override
    DoubleMatrix createTranspose(DoubleMatrix matrix) {
        return matrix.transpose();
    }

    @Override
    DoubleMatrix mul(DoubleMatrix a, DoubleMatrix b) {
        return a.mmul(b);
    }

    @Override
    DoubleMatrix add(DoubleMatrix a, DoubleMatrix b) {
        return a.add(b);
    }
}
