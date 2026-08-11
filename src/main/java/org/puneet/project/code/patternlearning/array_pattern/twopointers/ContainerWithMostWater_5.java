package org.puneet.project.code.patternlearning.array_pattern.twopointers;

public class ContainerWithMostWater_5 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    public static int maxArea(int[] height) {
        int low = 0, high = height.length - 1;
        int maxArea = 0;
        while (low < high) {
            int area = Math.min(height[low], height[high]) * (high - low);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxArea;
    }
}
