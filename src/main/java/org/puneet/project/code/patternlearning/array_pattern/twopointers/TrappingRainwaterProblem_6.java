package org.puneet.project.code.patternlearning.array_pattern.twopointers;

public class TrappingRainwaterProblem_6 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int totalWaterTrapped = trapBrute(height);
        int totalWaterTrapped = trap(height);
        System.out.println(totalWaterTrapped);
    }
// Two pointer approch

    private static int trap(int[] height) {
        int totalWaterTrapped = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]); //maintaining the left boundary
            rightMax = Math.max(rightMax, height[right]); // maintaining the right boundary
            // As we are doing in brute force. We are maintaing the min between left max and right max
            if (leftMax < rightMax) {
                totalWaterTrapped += leftMax - height[left];
                left++;
            }
            else {
                totalWaterTrapped += rightMax - height[right];
                right--;
            }
        }
        return totalWaterTrapped;
    }

    private static int trapBrute(int[] height) {
        int n = height.length;
        int totalWaterTrapped = 0;
        for (int i = 0; i < height.length; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < n; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            int currArea = (Math.min(leftMax, rightMax)) - height[i];
            totalWaterTrapped = currArea + totalWaterTrapped;
        }
        return totalWaterTrapped;
    }
}
