package br.fag;
import br.fag.matrix.Matrix;
import br.fag.parallelSumTask.ParallelSumTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Matrix matrix = new Matrix(1000, 1000);
        matrix.populate();

        long start = System.currentTimeMillis();
        long sequentialSum = matrix.sumSequential();
        long end = System.currentTimeMillis();
        System.out.println("Soma Sequencial:  " + sequentialSum + " Time: " + (end - start) + "ms");

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        List<ParallelSumTask> tasks = new ArrayList<>();
        for (int i = 0; i < matrix.getRows(); i++) {
            tasks.add(new ParallelSumTask(matrix.getRow(i)));
        }
        start = System.currentTimeMillis();
        List<Future<Long>> results = executor.invokeAll(tasks);
        long parallelSum = 0;
        for (Future<Long> result : results) {
            parallelSum += result.get();
        }
        end = System.currentTimeMillis();
        System.out.println("Soma Paralela: " + parallelSum + " Time: " + (end - start) + "ms");

        executor.shutdown();
    }
}
