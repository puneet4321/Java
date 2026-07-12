package org.puneet.project.code.patternlearning.slidingwindow.strings;

import java.util.HashMap;

public class MinimumWindowSubstring_13 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String ans = minWindow(s, t);
        System.out.println(ans);
    }

    private static String minWindow(String s, String t) {
        String res = "";
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> sMap = new HashMap<>();
        // fill t map.
        for (Character c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char charAtRight = s.charAt(right);
            // Expansion phase
            sMap.put(charAtRight, sMap.getOrDefault(charAtRight, 0) + 1);
            if (tMap.containsKey(charAtRight) && tMap.get(charAtRight) >= sMap.get(charAtRight)) {
                // ek chahiye tha ek hi hai.
                // means we have taken a required character .
                count--;
            }
            // shrink pase
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                // shrink phase
                char charAtLeft = s.charAt(left);
                sMap.put(charAtLeft, sMap.get(charAtLeft) - 1);
                if (tMap.containsKey(charAtLeft) && tMap.get(charAtLeft) > sMap.get(charAtLeft)) {
                    count++;
                }
                left++;
            }
        }
        return res;
    }
}
