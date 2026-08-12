package org.puneet.project.code.patternlearning.stack.experssion_evalutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class EvaluateReversePolishNotation_2 {
    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
//        System.out.println(evalRPNBrute(tokens));
        System.out.println(evalRPN(tokens));
    }

    private static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String ch : tokens) {
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (ch.equals("+")) stack.push(num1 + num2);
                else if (ch.equals("-")) stack.push(num1 - num2);
                else if (ch.equals("*")) stack.push(num1 * num2);
                else if (ch.equals("/")) stack.push(num1 / num2);
            } else stack.push(Integer.parseInt(ch));
        }
        return stack.peek();
    }

    public static int evalRPNBrute(String[] tokens) {
        // Will manuplate this list
        List<String> tokenList = new ArrayList<>(Arrays.asList(tokens));
        while (tokenList.size() > 1) {
            for (int i = 0; i < tokenList.size(); i++) {
                String ch = tokenList.get(i);
                if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
                    int num1 = Integer.parseInt(tokenList.get(i - 2));
                    int num2 = Integer.parseInt(tokenList.get(i - 1));
                    int val = 0;
                    if (ch.equals("+")) val = num1 + num2;
                    else if (ch.equals("-")) val = num1 - num2;
                    else if (ch.equals("*")) val = num1 * num2;
                    else if (ch.equals("/")) val = num1 / num2;
                    tokenList.set(i - 2, String.valueOf(val));
                    tokenList.remove(i);
                    tokenList.remove(i - 1);
                    break; // To break the first iteration
                }
            }
        }
        return Integer.parseInt(tokenList.get(0));
    }
}
