package org.puneet.project.code.arrays;

public class MaximumSubArraySum_13 {
    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Sum of Max sub array brute force is : " + maximumSubArraySumBrute(arr));
        // Kadane Algorithm. We also have to mention the index from where to where the array is.
        System.out.println("Sum of Max sub array optimal is : " + maximumSubArraySumOptimal(arr));
    }

    private static int maximumSubArraySumOptimal(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int startIndex = -1;
        int endIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (sum == 0) startIndex = i; // whenever sum is zero. It's the start of index
            sum += arr[i];
            if (sum > max) {
             max = sum;
             endIndex = i; // whenever sum is > max. we found max sub array and it's end is curr idx.
            };
            if (sum < 0) {
                sum = 0;
            }
        }
        System.out.println("Start idx : " + startIndex + " End idx : " + endIndex);
        return max;
    }

    private static int maximumSubArraySumBrute(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
