package org.puneet.project.code.patternlearning.array_pattern.twopointers;

import java.util.Arrays;

public class SquareOfSortedArray_3 {
    public static void main(String[] args) {
        int[] sortedSquares = sortedSquaresBruteForce(new int[]{-4, -1, 0, 3, 10});
        System.out.println(" sortedSquares " + Arrays.toString(sortedSquares));
    }

    public static int[] sortedSquaresBruteForce(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }
}
