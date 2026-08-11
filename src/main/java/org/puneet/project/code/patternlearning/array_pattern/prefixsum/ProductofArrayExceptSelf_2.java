package org.puneet.project.code.patternlearning.array_pattern.prefixsum;

import java.util.Arrays;

public class ProductofArrayExceptSelf_2 {
    public static void main(String[] args) {
        System.out.println(" brute : " + Arrays.toString(productExceptSelfBrute(new int[]{1, 2, 3, 4})));
        System.out.println(" Optimal : " + Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    private static int[] productExceptSelf(int[] nums) {
        int[] prodExceptItself = new int[nums.length];
        int[] leftProdExceptItself = new int[nums.length];
        leftProdExceptItself[0] = 1; // As there is no element of left for idx 0. So its product should be 1.
        int[] rightProdExceptItself = new int[nums.length]; // As there is no element of right for last idx and we are calculating right product. So its product should be 1.
        rightProdExceptItself[nums.length - 1] = 1;
        // Filling the right product array
        for (int i = 1; i < nums.length; i++) {
            leftProdExceptItself[i] = leftProdExceptItself[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProdExceptItself[i] = rightProdExceptItself[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            prodExceptItself[i] = leftProdExceptItself[i] * rightProdExceptItself[i];
        }
        return prodExceptItself;
    }

    public static int[] productExceptSelfBrute(int[] nums) {
        int[] product = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prodOfI = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    int num = nums[j];
                    prodOfI *= num;
                }
            }
            product[i] = prodOfI;
        }
        return product;
    }
}
