package org.puneet.project.code.patternlearning.kadane;

public class MaximumProductSubarray_2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, -0, 4 , 4};
        int maxProduct = maxProduct(nums);
        System.out.println(maxProduct);
    }

    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        int leftMaxProduct = 1;
        int rightMaxProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            if (leftMaxProduct == 0) leftMaxProduct = 1;
            if (rightMaxProduct == 0) rightMaxProduct = 1;
            leftMaxProduct *= nums[i];
            rightMaxProduct *= nums[nums.length - i - 1];
            maxProduct = Math.max(maxProduct, Math.max(leftMaxProduct, rightMaxProduct));
        }
        return maxProduct;
    }
}
