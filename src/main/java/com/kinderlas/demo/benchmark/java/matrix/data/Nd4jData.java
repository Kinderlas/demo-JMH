
package com.kinderlas.demo.benchmark.java.matrix.data;

import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Nd4jData extends AbstractMatrixData<INDArray>{

    public Nd4jData(List<Pair<Integer, Integer>> shapes) {
        super(shapes);
    }

    @Override
    INDArray createMatrix(Integer r, Integer c) {
        return Nd4j.rand(r, c);
    }

    @Override
    INDArray createTranspose(INDArray matrix) {
        return matrix.transpose();
    }

    @Override
    INDArray mul(INDArray a, INDArray b) {
        return a.mmul(b);
    }

    @Override
    INDArray add(INDArray a, INDArray b) {
        return a.add(b);
    }

}
