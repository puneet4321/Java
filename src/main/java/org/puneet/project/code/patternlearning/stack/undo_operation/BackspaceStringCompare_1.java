package org.puneet.project.code.patternlearning.stack.undo_operation;

public class BackspaceStringCompare_1 {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {
        return buildbackSpacedStr(s).equals(buildbackSpacedStr(t));
    }

    public static String buildbackSpacedStr(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                if (!sb.isEmpty()) sb.deleteCharAt(sb.length() - 1);
            } else sb.append(ch);
        }
        return sb.toString();
    }
}
