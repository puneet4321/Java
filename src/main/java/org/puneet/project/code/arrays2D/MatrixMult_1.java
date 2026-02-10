package org.puneet.project.code.arrays2D;

import java.util.Arrays;

public class MatrixMult_1 {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] B = {
                {1, 0, 2, 1},
                {0, 1, 1, 0},
                {1, 1, 0, 2}
        };

        int[][] prod = productOfMatrics(A, B);
        System.out.println("productOfMatrics : " + Arrays.deepToString(prod));
    }

    private static int[][] productOfMatrics(int[][] a, int[][] b) {
        int[][] prod = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    prod[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return prod;
    }
}
