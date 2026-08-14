package org.puneet.project.code.patternlearning.stack.Greedy;

import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses_3 {
    public static void main(String[] args) {
//        String s = "lee(t(c)o)e)";
        String s = "))((";
        System.out.println(minRemoveToMakeValid(s));
    }

    public static String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(i);
            else if (s.charAt(i) == ')') {
                if (!stack.isEmpty()) stack.pop();
                else chars[i] = '#';
            }
        }

        while (!stack.isEmpty()) chars[stack.pop()] = '#';
        for (char ch : chars) if (ch != '#') ans.append(ch);
        return ans.toString();
    }
}
