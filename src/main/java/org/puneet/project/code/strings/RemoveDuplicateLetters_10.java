package org.puneet.project.code.strings;

import org.springframework.util.StringUtils;

import java.util.Arrays;

public class RemoveDuplicateLetters_10 {
    public static void main(String[] args) {
        String str = "cbacdcbc";
        String res = removeDuplicateLetters(str);
        System.out.println(res);
    }

    private static String removeDuplicateLetters(String str) {
        String result = "";
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
                result = result.substring(0, result.length() - 1);
                visited[removed - 'a'] = false;
            }
            result = result + ch;
            visited[ch - 'a'] = true;
        }
        return result;
    }

}
