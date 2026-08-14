package org.puneet.project.code.patternlearning.stack.Greedy;

public class RemoveDuplicateLetters_2 {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String str) {
        StringBuilder result = new StringBuilder();
        int[] lastOccurrence = new int[26];
        boolean[] visited = new boolean[26];
        for (int i = 0; i < str.length(); i++) {
            lastOccurrence[str.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (visited[ch - 'a']) continue;
            while (!result.isEmpty() && result.charAt(result.length() - 1) > ch && lastOccurrence[result.charAt(result.length() - 1) - 'a'] > i) {
                char removed = result.charAt(result.length() - 1);
                result.deleteCharAt(result.length() - 1);
                visited[removed - 'a'] = false;
            }
            result = result.append(ch);
            visited[ch - 'a'] = true;
        }
        return result.toString();
    }
}
