package org.puneet.project.code.strings;

public class ReverseWordsInString_13 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String res = reverseWords(s);
        System.out.println(res);
    }

    private static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        String[] s1 = s.split(" ");
        for (String eachWord : s1) {
            res.append(new StringBuilder(eachWord).reverse()).append(" ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }
}
