package org.puneet.project.code.patternlearning.stack.undo_operation;

public class MinimumStringLengthAfterRemovingSubstrings_3 {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        System.out.println(minLength(s));
    }

    public static int minLength(String s) {
        StringBuilder stack = new StringBuilder();
        for (char currChar : s.toCharArray()) {
            if ((currChar == 'B') && !stack.isEmpty()) {
                if (stack.charAt(stack.length() - 1) == 'A') {
                    stack.deleteCharAt(stack.length() - 1);
                    // we need to skip the curr char if we encounter the substring that has to be removed.
                    continue;
                }
            } else if ((currChar == 'D') && !stack.isEmpty()) {
                if (stack.charAt(stack.length() - 1) == 'C') {
                    stack.deleteCharAt(stack.length() - 1);
                    // we need to skip the curr char if we encounter the substring that has to be removed.
                    // Prevents to add unneccessary element in stack
                    continue;
                }
            }
            stack.append(currChar);
        }
        return stack.length();
    }
}
