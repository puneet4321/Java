package org.puneet.project.code.arrays2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LuckyNumber_4 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {16, 15, 14, 13}
        };
        List<Integer> luckyNumber = new ArrayList<>();
        luckyNumber(matrix, luckyNumber);
        System.out.println("luckyNumber in 2dMatrix " + luckyNumber);
    }

    private static void luckyNumber(int[][] matrix, List<Integer> luckyNumber) {
        for (int i = 0; i < matrix.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int smallestInRow = smallestInArray(matrix[i], map);
            System.out.println(smallestInRow);
            //checkIf its Lastest in column
            maxInColumn(map.get(smallestInRow), matrix.length, smallestInRow, matrix, luckyNumber);
        }
    }

    private static void maxInColumn(int column, int row, int smallestInRow, int[][] matrix, List<Integer> luckyNumber) {
        boolean isSmallest = true;
        for (int j = 0; j < row; j++) {
            if (matrix[j][column] > smallestInRow) {
                isSmallest = false;
            }
        }
        if (isSmallest) {
            luckyNumber.add(smallestInRow);
        }
    }

    private static int smallestInArray(int[] matrix, HashMap<Integer, Integer> map) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] < min) {
                min = matrix[i];
                map.put(min, i);
            }
        }
        return min;
    }
}

