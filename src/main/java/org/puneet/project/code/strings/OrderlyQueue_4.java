package org.puneet.project.code.strings;

import java.util.Arrays;

public class OrderlyQueue_4 {
    public static void main(String[] args) {
        String str = "cab";
        int k = 1;
        String ans = orderlyQueue(str, k);
        System.out.println("answer : " + ans);
    }

    private static String orderlyQueue(String str, int k) {
        String result = str;
        int n = str.length();
        if (k <= 1) {
            for (int i = 0; i < n - 1; i++) {
                String subStr = str.substring(1);
                subStr = subStr + str.charAt(0);
                str = subStr;
                if (str.compareTo(result) < 0) {
                    result = subStr;
                }
            }
        } else {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            str = String.valueOf(charArray);
            result = str;
        }
        return result;
    }
}
