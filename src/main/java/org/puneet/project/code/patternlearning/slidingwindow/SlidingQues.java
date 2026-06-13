package org.puneet.project.code.patternlearning.slidingwindow;

public class SlidingQues {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 6};
        int k = 3;
        slidingWindow(arr, k);
    }

    private static void slidingWindow(int[] arr, int k) {
        System.out.printf("" + (arr.length - k));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length - k; i++) {
            int tempMax = 0;
            for (int j = i; j < i + k; j++) {
                tempMax = tempMax + arr[j];
                max = Math.max(max, tempMax);
            }
        }
        System.out.println(" Max sub array sum " + max);
    }
}
