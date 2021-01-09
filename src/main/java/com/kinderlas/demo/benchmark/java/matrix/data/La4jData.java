
package com.kinderlas.demo.benchmark.java.matrix.data;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.tuple.Pair;
import org.la4j.factory.Basic2DFactory;
import org.la4j.matrix.Matrix;
import org.la4j.matrix.dense.Basic2DMatrix;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class La4jData extends AbstractMatrixData<Matrix> {

    private final Basic2DFactory basic2DFactory = new Basic2DFactory();

    public La4jData(List<Pair<Integer, Integer>> shapes) {
        super(shapes);
    }

    @Override
    Matrix createMatrix(Integer r, Integer c) {
        final Random random = new Random();
        Matrix matrix = new Basic2DMatrix(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix.set(i, j, random.nextDouble());
            }
        }
        return matrix;
    }

    @Override
    Matrix createTranspose(Matrix matrix) {
        return matrix.transpose();
    }

    @Override
    Matrix mul(Matrix a, Matrix b) {
        return a.multiply(b);
    }

    @Override
    Matrix add(Matrix a, Matrix b) {
        return a.add(b);
    }
}
