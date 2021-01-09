
package com.kinderlas.demo.benchmark.java.matrix.data;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.random.RandomDataGenerator;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CommonMath3Data extends AbstractMatrixData<RealMatrix>{

    public CommonMath3Data(List<Pair<Integer, Integer>> shapes) {
        super(shapes);
    }

    @Override
    RealMatrix createMatrix(Integer r, Integer c) {
        return commonMathRandomMatrix(r, c);
    }

    @Override
    RealMatrix createTranspose(RealMatrix matrix) {
        return matrix.transpose();
    }

    @Override
    RealMatrix mul(RealMatrix a, RealMatrix b) {
        return a.multiply(b);
    }

    @Override
    RealMatrix add(RealMatrix a, RealMatrix b) {
        return a.add(b);
    }

    private static RealMatrix commonMathRandomMatrix(int r, int c) {
        double[][] d = new double[r][c];
        var random = new RandomDataGenerator();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                d[i][j] = random.nextGaussian(0, 1);
            }
        }
        return new Array2DRowRealMatrix(d, false);
    }

}
