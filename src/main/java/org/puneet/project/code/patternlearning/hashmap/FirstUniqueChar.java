package org.puneet.project.code.patternlearning.hashmap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "loveleetcode";
        int idxOfFirstUniqueChar = firstUniqCharOptimal(s);
        System.out.println("FirstUniqueChar : " + idxOfFirstUniqueChar);
    }

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = -1;
        // Storing the frequency count
        for (char ch : s.toCharArray()) {
            if (Objects.isNull(map.get(ch))) map.put(ch, 1);
            else map.put(ch, map.get(ch) + 1);
        }
        for (int i = 0; i <= s.length() - 1; i++) {
            if (map.get(s.charAt(i)) == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static int firstUniqCharOptimal(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
