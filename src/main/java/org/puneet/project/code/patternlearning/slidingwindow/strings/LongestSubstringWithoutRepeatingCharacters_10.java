package org.puneet.project.code.patternlearning.slidingwindow.strings;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_10 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int countOfLongestSSWithoutDuplicate = lengthOfLongestSubstring(s);
        System.out.println(countOfLongestSSWithoutDuplicate);
    }

    public static int lengthOfLongestSubstring(String s) {
        int countOfLongestSSWithoutDuplicate = 0;
        int left = 0;
        HashMap<Character, Integer> alreadySeenMap = new HashMap<>();
        for (int r = 0; r < s.length(); r++) {
            char charAtRight = s.charAt(r);
            // Expansion Phase of
            alreadySeenMap.put(charAtRight, alreadySeenMap.getOrDefault(charAtRight, 0) + 1);
            // checking if duplicate. i e shrinking phase
            while (alreadySeenMap.get(charAtRight) > 1) {
                char charAtLeft = s.charAt(left);
                alreadySeenMap.put(charAtLeft, alreadySeenMap.get(charAtLeft) - 1);
                left++;
            }
            countOfLongestSSWithoutDuplicate = Math.max(countOfLongestSSWithoutDuplicate, r - left + 1);
        }
        return countOfLongestSSWithoutDuplicate;
    }
}
