package org.puneet.project.code.patternlearning.hashmap;

import java.util.HashMap;

public class MaximumNumberofBalloons_3 {
    public static void main(String[] args) {
        // balloon
        String s = "loonbalxballpoon";
        int balloons = maxNumberOfBalloonsOptimal(s);
        System.out.println("max balloon : " + balloons);
    }

    public static int maxNumberOfBalloons(String text) {
        int maxBallons = 0;
        String bs = "balon";
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : text.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        while (map.getOrDefault('b', 0) > 0 && map.getOrDefault('a', 0) > 0
                && map.getOrDefault('l', 0) > 1   // need 2 l's per balloon
                && map.getOrDefault('o', 0) > 1   // need 2 o's per balloon
                && map.getOrDefault('n', 0) > 0) {
            for (int i = 0; i < bs.length(); i++) {
                if ((bs.charAt(i) == 'b' || bs.charAt(i) == 'a' || bs.charAt(i) == 'n') && bs.charAt(i) > 0) {
                    map.put(bs.charAt(i), map.get(bs.charAt(i)) - 1);
                } else if ((bs.charAt(i) == 'l' || bs.charAt(i) == 'o') && bs.charAt(i) > 1) {
                    map.put(bs.charAt(i), map.get(bs.charAt(i)) - 2);
                }
                if (i == bs.length() - 1) {
                    maxBallons = maxBallons + 1;
                }
            }
        }
        return maxBallons;
    }

    public static int maxNumberOfBalloonsOptimal(String text) {
        int[] arr = new int[26];
        char[] t = text.toCharArray();
        for (char c : t) {
            arr[c - 'a']++;
        }
        int ans = arr['b' - 'a'];
        ans = Math.min(ans, arr['a' - 'a']);
        ans = Math.min(ans, (int) arr['l' - 'a'] / 2);
        ans = Math.min(ans, (int) arr['o' - 'a'] / 2);
        ans = Math.min(ans, arr['n' - 'a']);
        return ans;
    }
}
