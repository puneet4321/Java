package org.puneet.project.code.patternlearning.array_pattern.twopointers.strings;

public class LongestPalindromicSubstring_8 {
    public static void main(String[] args) {
        String s = "babad";
        String longestPalindromeBrute = longestPalindromeBrute(s);
        String longestPalindrome = longestPalindrome(s);
        System.out.println("longestPalindromeOptimal ::  " + longestPalindrome);
    }

    public static String longestPalindrome(String s) {
        String ans = "";
        // for odd lenght longest Palindrome
        char[] sCharArray = s.toCharArray();
        for (int axis = 0; axis < s.length(); axis++) {
            int orbit = 1;
            int length = 1;
            while (axis - orbit >= 0 && axis + orbit < s.length()) {
                if (sCharArray[axis - orbit] == sCharArray[axis + orbit]) {
                    orbit = orbit + 1;
                    length = length + 2;
                } else {
                    break;
                }
            }

            if (length > ans.length()) {
                int startIndexForAns = (axis - (length / 2));
                int lastIndexForAns = startIndexForAns + length;
                ans = s.substring(startIndexForAns, lastIndexForAns);
            }
        }

        // for even length longest Palindrome
        for (int axis = 0; axis < s.length() - 1; axis++) {
            int orbit = 1;
            int length = 0;
            while (axis - orbit + 1 >= 0 && axis + orbit < s.length()) {
                if (sCharArray[axis - orbit + 1] == sCharArray[axis + orbit]) {
                    orbit = orbit + 1;
                    length = length + 2;
                } else {
                    break;
                }
            }

            if (length > ans.length()) {
                int startIndexForAns = ((axis - (length / 2)) + 1);
                int lastIndexForAns = startIndexForAns + length;
                ans = s.substring(startIndexForAns, lastIndexForAns);
            }
        }
        return ans;
    }

    private static String longestPalindromeBrute(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String longestPalindromeStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);
                System.out.println(substring);
                if (isPalindrome(substring) && substring.length() > longestPalindromeStr.length()) {
                    longestPalindromeStr = substring;
                }
            }
        }
        return longestPalindromeStr;
    }


    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
