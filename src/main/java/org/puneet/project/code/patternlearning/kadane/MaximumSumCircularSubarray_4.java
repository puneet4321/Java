package org.puneet.project.code.patternlearning.kadane;

import java.util.Arrays;

public class MaximumSumCircularSubarray_4 {
    public static void main(String[] args) {
        int[] nums = {5, -3, 5};
        maxSubarraySumCircular(nums);
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        int maxSum = maxSumKadane(nums);
        int minSum = minSumKadane(nums);
        int circularSum = totalSum - minSum;
        if (maxSum > 0) {
            return Math.max(circularSum, maxSum);
        }
        return maxSum;
    }

    public static int maxSumKadane(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static int minSumKadane(int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
            if (sum > 0) {
                sum = 0;
            }
        }
        return min;
    }
}
