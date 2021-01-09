
package com.kinderlas.demo.benchmark.java.matrix.data;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import cern.colt.function.DoubleFunction;
import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.impl.DenseDoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ColtData extends AbstractMatrixData<DoubleMatrix2D>{

    public ColtData(List<Pair<Integer, Integer>> shapes) {
        super(shapes);
    }

    @Override
    DoubleMatrix2D createMatrix(Integer r, Integer c) {
        return DoubleFactory2D.dense.random(r, c);
    }

    @Override
    DoubleMatrix2D createTranspose(DoubleMatrix2D matrix) {
        return  Algebra.DEFAULT.transpose(matrix);
    }

    @Override
    DoubleMatrix2D mul(DoubleMatrix2D a, DoubleMatrix2D b) {
        return Algebra.DEFAULT.mult(a, b);
    }

    @Override
    DoubleMatrix2D add(DoubleMatrix2D a, DoubleMatrix2D b) {
        // todo 找不到实现😂
        return null;
    }
}
