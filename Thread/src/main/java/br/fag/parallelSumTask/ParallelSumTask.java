package br.fag.parallelSumTask;

import java.util.concurrent.Callable;

public class ParallelSumTask implements Callable<Long> {
    private final int[] row;

    public ParallelSumTask(int[] row) {
        this.row = row;
    }

    @Override
    public Long call() {
        long sum = 0;
        for (int val : row) {
            sum += val;
        }
        return sum;
    }
}
