package org.puneet.project.code.patternlearning.stack.Greedy;

import java.util.Stack;

public class RemoveKDigits_1 {
    public static void main(String[] args) {
        String num = "10";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (char ch : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && ch < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        // If k is still remaining, remove from the end
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        // Build result
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        // Stack was popped from top, so reverse
        res.reverse();
        // Remove leading zeros
        int i = 0;
        while (i < res.length() && res.charAt(i) == '0') {
            i++;
        }
        // Everything was zero
        if (i == res.length()) return "0";

        return res.substring(i);
    }
}
