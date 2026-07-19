package org.puneet.project.code.patternlearning.prefixsum;

import java.util.Arrays;

public class PivotIndex_5 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int pivotIdx = pivotIndex(nums);
        System.out.println(pivotIdx);
    }

    public static int pivotIndex(int[] nums) {
        int pivotIdx = -1;
        int leftPreFixSum = 0;
        int totalSum = Arrays.stream(nums).sum();
        for (int i = 0; i < nums.length; i++) {
            int rightPreFixSum = totalSum - leftPreFixSum - nums[i];
            if (leftPreFixSum == rightPreFixSum) {
                pivotIdx = i;
                return pivotIdx;
            }
            leftPreFixSum = leftPreFixSum + nums[i];
        }
        return pivotIdx;
    }
}
