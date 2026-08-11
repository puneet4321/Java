package org.puneet.project.code.patternlearning.array_pattern.slidingwindow.strings;

import java.util.HashMap;

public class LongestSubstringwithKUniqueCharacters_11 {
    public static void main(String[] args) {
        String s = "aabacbebebe";
        System.out.println(longestKSubstr(s, 3));
    }

    public static int longestKSubstr(String s, int k) {
        int ans = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            //Expansion phase
            char charAtright = s.charAt(r);
            map.put(charAtright, map.getOrDefault(charAtright, 0) + 1);
            // shrink phase
            while (map.size() > k) {
                // shrink always happen from left
                char charAtLeft = s.charAt(left);
                map.put(charAtLeft, map.get(charAtLeft) - 1);
                if (map.get(charAtLeft) == 0) {
                    map.remove(charAtLeft);
                }
                left++;
            }
            if (map.size() == k) {
                ans = Math.max(ans, r - left + 1);
            }
        }
        return ans;
    }
}
