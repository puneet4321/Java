package org.puneet.project.code.patternlearning.slidingwindow;

import java.util.HashMap;

public class SubarrayswithKDifferentIntegers_7 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
//        int count = subarraysWithKDistinctBrute(nums, 2);
        int count = atMostK(nums, 2) - atMostK(nums, 1);
        System.out.println(count);
    }

    private static int atMostK(int[] nums, int k) {
        int count = 0;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            // Expansion phase
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            //Shrinking phasr
            while (map.size() > k) {
                //Decrement the frequency by 1 of left.
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            // calculating the no of subarray count between two points
            count += right - left + 1;
        }
        // This count is of subarray with less than and equal to k.
        return count;
    }

    private static int subarraysWithKDistinctBrute(int[] nums, int k) {
        int count = 0;
        for (int l = 0; l < nums.length; l++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int r = l; r < nums.length; r++) {
                map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
                // valid substring with k distinct integer
                if (map.size() == k) {
                    count++;
                } else if (map.size() > k) {
                    break;
                }
            }
        }
        return count;
    }

}
