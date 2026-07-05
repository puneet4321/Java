package org.puneet.project.code.patternlearning.twopointers.strings;

public class ValidPalindromeII_7 {
    public static void main(String[] args) {
        // If the given string is not palindrome. You can remove one charecter and make it palindrome.
        String s = "afgfea";
//        String s = "afgfa";
        Boolean isPalindrome = validPalindrome(s);
        System.out.println("isPalindrome : " + isPalindrome);
    }

    private static Boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return (isPalindrome(left + 1, right, s) || isPalindrome(left, right - 1, s));
            }
            left++;
            right--;
        }
        System.out.println("validPalindrome return form here");
        return true;
    }

    private static boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        System.out.println("validPalindrome return form there");
        return true;
    }
}
