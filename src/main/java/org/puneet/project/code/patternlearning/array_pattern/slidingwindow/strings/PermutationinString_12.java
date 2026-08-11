package org.puneet.project.code.patternlearning.array_pattern.slidingwindow.strings;

import java.util.HashMap;

public class PermutationinString_12 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";
        checkInclusion(s1, s2);
    }

    public static boolean checkInclusion(String s1, String s2) {
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
        }
        int left = 0;
        for (int r = 0; r < s2.length(); r++) {
            char rightChar = s2.charAt(r);
            s2Map[rightChar - 'a']++;
            // Shrinking phase
            if (r - left + 1 > s1.length()) {
                s2Map[s2.charAt(left) - 'a']--;
                left++;
            }


            // We found a ss of 2 length
            if (r - left + 1 == s1.length()) {
                boolean isInclusive = true;
                for (int i = 0; i < 26; i++) {
                    if (s1Map[i] != s2Map[i]) {
                        isInclusive = false;
                        break;
                    }
                }
                if (isInclusive) return true;
            }
        }
        return false;
    }
}
