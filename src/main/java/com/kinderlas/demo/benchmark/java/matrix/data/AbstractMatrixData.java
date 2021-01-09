

package com.kinderlas.demo.benchmark.java.matrix.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.tuple.Pair;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractMatrixData<T> {

    @Getter
    public Map<Pair<Integer, Integer>, List<T>> mMap;
    @Getter
    public Map<Pair<Integer, Integer>, List<T>> tmMap;

    protected Integer getArraySize() {
        return 100;
    }

    public AbstractMatrixData(List<Pair<Integer, Integer>> shapes) {
        long st = System.currentTimeMillis();
        mMap = new HashMap<>();
        tmMap = new HashMap<>();
        shapes.forEach(shape -> {
            List<T> mList = new ArrayList<>();
            List<T> revMList = new ArrayList<>(getArraySize());
            for (int i = 0; i < getArraySize(); i++) {
                var m = createMatrix(shape.getLeft(), shape.getRight());
                mList.add(m);
                revMList.add(createTranspose(m));
            }
            mMap.put(shape, mList);
            tmMap.put(shape, revMList);
        });
        log.info("{} init done:{}", this.getClass().getSimpleName(),
                System.currentTimeMillis() - st);
    }

    public T randomMul(Pair<Integer, Integer> shape) {
        return mul(mMap.get(shape).get(ThreadLocalRandom.current().nextInt(getArraySize())),
                tmMap.get(shape).get(ThreadLocalRandom.current().nextInt(getArraySize())));
    }

    public T randomAdd(Pair<Integer, Integer> shape) {
        return add(mMap.get(shape).get(ThreadLocalRandom.current().nextInt(getArraySize())),
                mMap.get(shape).get(ThreadLocalRandom.current().nextInt(getArraySize())));
    }

    abstract T createMatrix(Integer r, Integer c);

    abstract T createTranspose(T matrix);

    abstract T mul(T a, T b);

    abstract T add(T a, T b);

}
