package org.puneet.project.code.patternlearning.array_pattern.slidingwindow;

public class MaxConsecutiveOnes_3 {
    public static void main(String[] args) {
        int k = 3;
//        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] nums = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1};
//        int longestOnes = longestOnesBrute(nums, k);
//        int longestOnes1 = longestOnesBetter(nums, k);
        int longestOnes1 = longestOnesOptimal(nums, k);
        System.out.println(longestOnes1);
    }

    private static int longestOnesOptimal(int[] nums, int k) {
        int maxOnes = 0;
        int zerosCount = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zerosCount++;
            }
            if (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }
        }
        return nums.length - left;
    }

    private static int longestOnesBetter(int[] nums, int k) {
        int maxOnes = 0;
        int zerosCount = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zerosCount++;
            }
            while (zerosCount > k) {
                if (nums[left] == 0) {
                    zerosCount--;
                }
                left++;
            }
            maxOnes = Math.max(maxOnes, right - left + 1);
        }
        return maxOnes;
    }

    public static int longestOnesBrute(int[] nums, int k) {
        int maxOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            int zerosCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zerosCount++;
                }
                if (zerosCount > k) {
                    break;
                }
                maxOnes = Math.max(maxOnes, j - i + 1);
            }
        }
        return maxOnes;
    }
}


