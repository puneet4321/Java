package org.puneet.project.code.arrays2D;

import java.util.Arrays;

public class SetZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        setZeros(matrix);
    }

    private static void setZeros(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    cols[i] = 1;
                    rows[i] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(rows));
        System.out.println(Arrays.toString(cols));

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }
}
