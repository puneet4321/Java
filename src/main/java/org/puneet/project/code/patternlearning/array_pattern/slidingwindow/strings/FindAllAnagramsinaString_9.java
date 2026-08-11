package org.puneet.project.code.patternlearning.array_pattern.slidingwindow.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsinaString_9 {
    public static void main(String[] args) {
//        System.out.println(findAnagramsBrute("cbaebabacd", "abc"));
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int k = p.length();
        int count = p.length();
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) {
            return result;
        }
        int left = 0;
        HashMap<Character, Integer> pCountMap = new HashMap<>();
        for (char ch : p.toCharArray()) {
            pCountMap.put(ch, pCountMap.getOrDefault(ch, 0) + 1);
        }
        for (int right = 0; right < s.length(); right++) {
            // Expantion of window
            char chAtRight = s.charAt(right);
            int valOfRight = pCountMap.getOrDefault(chAtRight, 0);
            pCountMap.put(chAtRight, valOfRight - 1);
            valOfRight = pCountMap.get(chAtRight);
            if (valOfRight >= 0) count--;
            // shrinking of window
            if (right - left + 1 > p.length()) {
                // before incrementing left
                char charAtLeft = s.charAt(left);
                int valOfLeft = pCountMap.getOrDefault(charAtLeft, 0);
                if (valOfLeft >= 0) count++;
                pCountMap.put(charAtLeft, valOfLeft + 1);
                left++;
            }
            if (count == 0) {
                result.add(left);
            }
        }
        return result;
    }

    public static List<Integer> findAnagramsBrute(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int k = p.length();
        // frequesncy count of p string
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
        }
        // loop on s string, Get all 3 length substring
        for (int i = 0; i <= s.length() - k; i++) {
            int[] sCount = new int[26];
            for (int j = i; j < i + k; j++) {
                sCount[s.charAt(j) - 'a']++;
            }
            if (Arrays.equals(pCount, sCount)) {
                result.add(i);
            }
        }
        return result;
    }
}
