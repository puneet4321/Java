package org.puneet.project.code.patternlearning.array_pattern.prefixsum;

import java.util.HashMap;

public class SubarraySumsDivisiblebyK_4 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 0, -2, -3, 1};
        int k = 5;
        int count = subarraysDivByK(nums, k);
        System.out.println(count);
    }

    public static int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int preFixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preFixSum = preFixSum + nums[i];
            int rem = preFixSum % k;
            if (rem < 0) {
                rem += k;
            }
            if (map.containsKey(rem)) {
                count = count + map.get(rem);
            }
            // This step will always execute as we have to update the frequency for remainder everytime
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}
