package org.puneet.project.code.patternlearning.array_pattern.prefixsum;

import java.util.HashMap;

public class ContinuousSubarraySum_3 {
    public static void main(String[] args) {
        int[] nums = {2 , 4};
        int k = 6;
        boolean ans = checkSubarraySum(nums, k);
        System.out.println("ans: " + ans);
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        int currPreFixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currPreFixSum += nums[i];
            int modulo = ((currPreFixSum % k) + k) % k;
            if (remainderMap.containsKey(modulo)) {
                if (i - remainderMap.get(modulo) >= 2) {
                    return true;
                }
            } else {
                remainderMap.put(modulo, i);
            }
        }
        return false;
    }
}
