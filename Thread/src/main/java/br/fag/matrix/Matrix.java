package br.fag.matrix;

public class Matrix {
    private final int[][] data;

    public Matrix(int rows, int cols) {
        this.data = new int[rows][cols];
    }

    public void populate() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = (int) (Math.random() * 10);
            }
        }
    }

    public long sumSequential() {
        long sum = 0;
        for (int[] datum : data) {
            for (int i : datum) {
                sum += i;
            }
        }
        return sum;
    }

    public int getRows() {
        return data.length;
    }

    public int[] getRow(int index) {
        return data[index];
    }
}