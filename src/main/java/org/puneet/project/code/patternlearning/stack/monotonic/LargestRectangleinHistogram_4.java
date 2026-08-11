package org.puneet.project.code.patternlearning.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleinHistogram_4 {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int[] nseOnRight = nextSmallerElementOnRight(heights);
        int[] nseOnLeft = nextSmallerElementOnLeft(heights);
        for (int i = 0; i < heights.length; i++) {
            int width = nseOnRight[i] - nseOnLeft[i] - 1;
            int currArea = heights[i] * width;
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

    private static int[] nextSmallerElementOnRight(int[] heights) {
        int[] nseOnRight = new int[heights.length];
        Arrays.fill(nseOnRight, heights.length);
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                nseOnRight[i] = stack.peek();
            }
            stack.push(i);
        }
        return nseOnRight;
    }

    private static int[] nextSmallerElementOnLeft(int[] heights) {
        int[] nseOnLeft = new int[heights.length];
        Arrays.fill(nseOnLeft, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }
            if (!stack.isEmpty() && heights[i] > heights[stack.peek()]) {
                nseOnLeft[i] = stack.peek();
            }
            stack.push(i);
        }
        return nseOnLeft;
    }
}
