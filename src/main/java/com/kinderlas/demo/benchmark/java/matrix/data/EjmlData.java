
package com.kinderlas.demo.benchmark.java.matrix.data;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.tuple.Pair;
import org.ejml.simple.SimpleMatrix;

import lombok.extern.slf4j.Slf4j;



@Slf4j
public class EjmlData extends AbstractMatrixData<SimpleMatrix> {

    public EjmlData(List<Pair<Integer, Integer>> shapes) {
        super(shapes);
    }

    @Override
    SimpleMatrix createMatrix(Integer r, Integer c) {
        Random random = new Random();
        SimpleMatrix simpleMatrix = new SimpleMatrix(r, c);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                simpleMatrix.set(i, j, random.nextDouble());
            }
        }
        return simpleMatrix;
    }

    @Override
    SimpleMatrix createTranspose(SimpleMatrix matrix) {
        return matrix.transpose();
    }

    @Override
    SimpleMatrix mul(SimpleMatrix a, SimpleMatrix b) {
        return a.mult(b);
    }

    @Override
    SimpleMatrix add(SimpleMatrix a, SimpleMatrix b) {
        return a.plus(b);
    }
}
