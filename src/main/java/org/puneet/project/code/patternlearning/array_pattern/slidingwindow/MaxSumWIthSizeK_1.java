package org.puneet.project.code.patternlearning.array_pattern.slidingwindow;

public class MaxSumWIthSizeK_1 {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7, 6};
        int k = 3;
        int max = maxSumWIthSizeKBrute(arr, k);
        int maxSum = maxSumWIthSizeK(arr, k);
        System.out.println("maxSumWIthSizeKBrute " + max);
        System.out.println("maxSumWIthSizeK " + maxSum);
    }

    private static int maxSumWIthSizeK(int[] arr, int k) {
        int maxWindowSum = 0;
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += arr[i];
        }
        maxWindowSum = windowSum;
        for (int j = k; j < arr.length; j++) {
            windowSum = windowSum + arr[j];
            windowSum = windowSum - arr[j - k];
            maxWindowSum = Math.max(windowSum, maxWindowSum);
        }
        return maxWindowSum;
    }

    private static int maxSumWIthSizeKBrute(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length - k; i++) {
            int tempMax = 0;
            for (int j = i; j < i + k; j++) {
                tempMax = tempMax + arr[j];
            }
            max = Math.max(max, tempMax);
        }
        return max;
    }

}
