package org.puneet.project.code.arrays2D;

public class SearchIn2dArray_5 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {16, 15, 14, 13}
        };
        boolean found = searchIn2dArray(matrix, 0, matrix[0].length - 1, 6);
        System.out.println(found);
    }

    private static boolean searchIn2dArray(int[][] matrix, int minRow, int maxColumn, int target) {
        boolean isTargetFound = false;
        while (minRow < matrix.length && maxColumn >= 0) {
            if (!isTargetFound && matrix[minRow][maxColumn] == target) {
                isTargetFound = true;
                System.out.println(matrix[minRow][maxColumn]);
                break;
            } else if (matrix[minRow][maxColumn] > target) {
                maxColumn--;
            } else if (matrix[minRow][maxColumn] < target) {
                minRow++;
            }
        }
        return isTargetFound;
    }

}
