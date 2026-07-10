package org.puneet.project.code.patternlearning.slidingwindow;

public class SubarrayProductLessThanK_4 {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int productLessThanK = numSubarrayProductLessThanK(nums, 100);
        System.out.println(productLessThanK);
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int countOfSubArrayProductLessThanK = 0;
        int left = 0;
        int product = 1;
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            countOfSubArrayProductLessThanK = countOfSubArrayProductLessThanK + (right - left + 1);
        }
        return countOfSubArrayProductLessThanK;
    }
}

