package org.puneet.project.code.arrays2D;

public class WaveTraversal_2 {
    public static void main(String[] args) {
        int[][] matrix = {
                {11, 12, 13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
        };
        waveTraversal(matrix);
    }

    private static void waveTraversal(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.print(matrix[j][i] + " ");
                }
            }
            if (i % 2 != 0) {
                for (int k = matrix.length - 1; k >= 0; k--) {
                    System.out.print(matrix[k][i] + " ");
                }
            }
            System.out.println();
        }
    }

}
