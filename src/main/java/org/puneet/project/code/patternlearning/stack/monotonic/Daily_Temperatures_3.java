package org.puneet.project.code.patternlearning.stack.monotonic;

import java.util.Arrays;
import java.util.Stack;

public class Daily_Temperatures_3 {
    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans, 0);
        Stack<Integer> monotonicDecreasingStack = new Stack<>();// 4> 3> 2
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!monotonicDecreasingStack.isEmpty() && temperatures[i] >= temperatures[monotonicDecreasingStack.peek()]) {
                monotonicDecreasingStack.pop();
            }
            if (!monotonicDecreasingStack.isEmpty() && temperatures[i] < temperatures[monotonicDecreasingStack.peek()]) {
                ans[i] = monotonicDecreasingStack.peek() - i;
            }
            // Instead of value we will put index and do all the computation using index
            monotonicDecreasingStack.push(i);
        }
        return ans;
    }
}
