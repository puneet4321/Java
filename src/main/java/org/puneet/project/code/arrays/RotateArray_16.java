package org.puneet.project.code.arrays;

import java.util.Arrays;

import static org.puneet.project.code.arrays.RotateArray_3.reverseArray;

public class RotateArray_16 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
//        int[][] rotatedArray = rotateArrayBrute(matrix, matrix.length, matrix[0].length);
//        System.out.println(Arrays.deepToString(rotatedArray));

        int[][] rotatedArrayOptimal = rotateArrayOptimal(matrix, matrix.length, matrix[0].length);
        System.out.println("rotatedArrayOptimal" + Arrays.deepToString(rotatedArrayOptimal));
    }

    private static int[][] rotateArrayOptimal(int[][] matrix, int row, int column) {
        for (int r = 0; r < row - 1; r++) {
            for (int c = r + 1; c < column; c++) {
                int temp = matrix[r][c];
                matrix[r][c] = matrix[c][r];
                matrix[c][r] = temp;
            }
        }
//        System.out.println(Arrays.deepToString(matrix));
        // reverse each row now.
        for (int i = 0; i < row; i++) {
            reverseArray(matrix[i], 0, 3);
        }
        return matrix;
    }


    private static int[][] rotateArrayBrute(int[][] matrix, int row, int column) {
        int[][] rotatedArray = new int[row][column];
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < column; c++) {
                rotatedArray[c][row - 1 - r] = matrix[r][c];
            }
        }

        return rotatedArray;
    }
}
