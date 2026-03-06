package org.puneet.project.code.strings;

public class DetectCapital_7 {
    public static void main(String[] args) {
//        leetcode , Leetcode , LEETCODE => TRUE else false ;
        String str = "eeL";
        boolean isCapital = detectCapital(str);
        System.out.println("isCapital: " + isCapital);
    }

    private static boolean detectCapital(String str) {
        if (allCapital(str) || allSmall(str.substring(1))) {
            return true;
        }
        return false;
    }

    private static boolean allSmall(String substring) {
        boolean allSmall = true;
        for (char c : substring.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                allSmall = false;
                break;
            }
        }
        System.out.println("allSmall: " + allSmall);
        return allSmall;
    }

    private static boolean allCapital(String str) {
        boolean allCapital = true;
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                allCapital = false;
                break;
            }
        }
        System.out.println("allCapital: " + allCapital);
        return allCapital;
    }
}
