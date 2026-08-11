package org.puneet.project.code.patternlearning.array_pattern.slidingwindow;

public class MaxConsecutiveOnes_2 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        int maxOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxOnes);
    }

    private static int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int finalMaxCountOnes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                maxOnes++;
            } else {
                finalMaxCountOnes = Math.max(finalMaxCountOnes, maxOnes);
                maxOnes = 0;
            }
        }
        finalMaxCountOnes = Math.max(finalMaxCountOnes, maxOnes);
        return finalMaxCountOnes;
    }
}
