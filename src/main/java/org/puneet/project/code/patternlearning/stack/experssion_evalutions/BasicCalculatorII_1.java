package org.puneet.project.code.patternlearning.stack.experssion_evalutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculatorII_1 {
    public static void main(String[] args) {
        String s = "3+2*2";
//        int evaluateExpression = calculateBruteForce(s);
        int evaluateExpression = calculate(s);
        System.out.println(evaluateExpression);
    }

/*
     * Intuition:
     * We scan the expression left to right and build each number as we go.
     * When we hit an operator (or the end), we apply the *previous* operator
     * to the number we just finished building.
     * + and - are deferred by pushing values onto a stack (negative for -).
     * * and / are applied immediately using the top of the stack, which
     * respects operator precedence without needing parentheses handling.
     * At the end, summing the stack gives the final result.
     *
     * Summary:
     * Evaluates a string expression containing non-negative integers and
     * operators +, -, *, / (integer division), with optional spaces.
     * Input:  s — the expression string (e.g. "3+2*2")
     * Output: the integer result of evaluating the expression (e.g. 7)
*/
    private static int calculate(String s) {
        // Holds numbers that will be added together at the end
        Stack<Integer> stack = new Stack<>();
        // Operator that applies to the number currently being built; start with '+' for the first number
        char prevOperator = '+';
        // Current multi-digit number being built from consecutive digits
        int num = 0;
        // Loop one past the last character so the final number gets processed
        for (int i = 0; i <= s.length(); i++) {
            // At the end, use a dummy '+' to flush the last number; otherwise read the current char
            char currOperator = (i == s.length()) ? '+' : s.charAt(i);
            // If this char is a digit, extend the current number (handles multi-digit values)
            if (Character.isDigit(currOperator)) {
                // Shift left by one decimal place and add the new digit
                num = num * 10 + (currOperator - '0');
            // Ignore spaces; on any real operator (or the dummy end), apply prevOperator
            } else if (currOperator != ' ') {
                // Previous op was '+': keep this number as a positive term for later
                if (prevOperator == '+') {
                    stack.push(num);
                // Previous op was '-': keep this number as a negative term for later
                } else if (prevOperator == '-') {
                    stack.push(-num);
                // Previous op was '*': multiply immediately with the last stacked value
                } else if (prevOperator == '*') {
                    stack.push(stack.pop() * num);
                // Previous op was '/': divide immediately with the last stacked value (integer division)
                } else if (prevOperator == '/') {
                    stack.push(stack.pop() / num);
                }
                // Remember the operator we just saw for the next number
                prevOperator = currOperator;
                // Reset so we can start building the next number
                num = 0;
            }
        }
        // Reuse num as the running total of all stacked values
        num = 0;
        // Add every value left on the stack (all + / - terms and already-reduced * / results)
        while (!stack.isEmpty()) {
            num += stack.pop();
        }
        // Return the final evaluated result
        return num;
    }

    public static int calculateBruteForce(String s) {
        List<Integer> nums = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        int num = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ' ') continue;
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else {
                nums.add(num);
                operators.add(ch);
                num = 0;
            }
        }
        nums.add(num);
        for (int i = 0; i < operators.size(); ) {
            char operator = operators.get(i);
            if (operator == '*' || operator == '/') {
                int num1 = nums.get(i);
                int num2 = nums.get(i + 1);
                int val = operators.get(i) == '*' ? num1 * num2 : num1 / num2;
                nums.set(i, val);
                nums.remove(i + 1);
                operators.remove(i);
            } else i++;
        }
        int result = nums.get(0);
        for (int i = 0; i < operators.size(); i++) {
            char operator = operators.get(i);
            if (operator == '+') result += nums.get(i + 1);
            else result -= nums.get(i + 1);
        }
        return result;
    }
}
