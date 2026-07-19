package org.puneet.project.code.patternlearning.kadane;

public class MaximumAbsoluteSumofAnySubarray_3 {
    public static void main(String[] args) {
        int[] nums = {2, -5, 1, -4, 3, -2};
        int sum = maxAbsoluteSumBrute(nums);
        int sumFromOptimal = maxAbsoluteSum(nums);
        System.out.println(sumFromOptimal);
    }

    // This Kadabe By defalut. which tell us to calculayte maximum subarray sum.
    public static int maxAbsoluteSum(int[] nums) {
        int maxSum = maxSumKadane(nums);
        int minSumKadane = Math.abs(minSumKadane(nums));
        System.out.println("minSumKadane: " + minSumKadane);
        System.out.println("maxSumKadane: " + maxSum);
        return Math.max(maxSum, minSumKadane);
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


    public static int maxAbsoluteSumBrute(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum = currentSum + nums[j];
                maxSum = Math.max(maxSum, Math.abs(currentSum));
            }
        }
        return maxSum;
    }
}
