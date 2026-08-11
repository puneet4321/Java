package org.puneet.project.code.patternlearning.array_pattern.slidingwindow;

public class MinimumSizeSubarraySum_5 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int minSubArrayLen = minSubArrayLen(nums, target);
        System.out.println(minSubArrayLen);
    }

    private static int minSubArrayLen(int[] nums, int target) {
        int minSubArrayLen = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            while (sum >= target) {
                minSubArrayLen = Math.min(minSubArrayLen, r - left + 1);
                // shirnk the window
                sum = sum - nums[left];
                left++;
            }
        }
        // No subarray found case
        if (minSubArrayLen == Integer.MAX_VALUE) {
            minSubArrayLen = 0 ;
        }
        return minSubArrayLen;
    }
}