package org.puneet.project.code.arrays;

public class MaxConsecutiveOnes_9 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1};
        maxConsecutiveOnes(arr);
    }

    private static void maxConsecutiveOnes(int[] arr) {
        int maxOneCount = 0;
        int finalMaxOneCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                maxOneCount = maxOneCount + 1;
            } else {
                finalMaxOneCount = Math.max(maxOneCount, finalMaxOneCount);
                maxOneCount = 0;
            }
        }
        finalMaxOneCount = Math.max(maxOneCount, finalMaxOneCount);
        System.out.println("maxOneCount : " + finalMaxOneCount);
    }
}
