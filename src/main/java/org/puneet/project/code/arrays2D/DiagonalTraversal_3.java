package org.puneet.project.code.arrays2D;

public class DiagonalTraversal_3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        diagonalTraversal(matrix) ;
    }

    private static void diagonalTraversal(int[][] matrix) {
        for (int g = 0; g < matrix.length; g++) {
            for(int i = 0 , j = g ; j < matrix.length ;i++, j++) {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
