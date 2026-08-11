package org.puneet.project.code.patternlearning.array_pattern.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;
        int count = subarraySum(nums, k);
        System.out.println("Total no. of subarrays with sum  : " + k + " : is " + count);
    }

    public static int subarraySum(int[] nums, int k) {
        int totalCount = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int r = 0; r < nums.length; r++) {
            prefixSum += nums[r];
            int target = prefixSum - k;
            if (map.containsKey(target)) {
                totalCount += map.get(target);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return totalCount;
    }
}
