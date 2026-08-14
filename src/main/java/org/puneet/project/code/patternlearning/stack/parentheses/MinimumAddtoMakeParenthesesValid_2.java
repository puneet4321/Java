package org.puneet.project.code.patternlearning.stack.parentheses;

import java.util.LinkedHashSet;
import java.util.Stack;
import java.util.stream.Collectors;

public class MinimumAddtoMakeParenthesesValid_2 {
    public static void main(String[] args) {
        String s = ")))";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else {
                if (!stack.isEmpty()) stack.pop();
                else count++;
            }
        }
        System.out.println(stack.size());
        return count + stack.size();
    }
}
