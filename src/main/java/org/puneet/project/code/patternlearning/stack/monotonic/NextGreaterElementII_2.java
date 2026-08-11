package org.puneet.project.code.patternlearning.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII_2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = nums[i % n];
            // curr i is greater than stack top so pop for getting the NGE
            while (!stack.isEmpty() && num >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty() && num < stack.peek() && i < n) {
                    ans[i] = stack.peek();
                }
            stack.push(num);
        }
        return ans;
    }
}
