package org.puneet.project.code.patternlearning.stack.undo_operation;

public class RemoveAllAdjacentDuplicatesinString_2 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }

    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(); // used as stack
        for (char ch : s.toCharArray()) {
            if (!sb.isEmpty() && ch == sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
            } else sb.append(ch);
        }
        return sb.toString();
    }
}
