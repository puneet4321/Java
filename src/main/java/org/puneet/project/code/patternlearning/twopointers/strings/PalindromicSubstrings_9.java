package org.puneet.project.code.patternlearning.twopointers.strings;

public class PalindromicSubstrings_9 {
    public static void main(String[] args) {
        String s = "aaa";
        int totalPalindromeSubstring = countSubstrings(s);
        System.out.println("totalPalindromeSubstring : " + totalPalindromeSubstring);
    }

    private static int countSubstrings(String s) {
        int ans = 0;
        // for odd lenght longest Palindrome
        char[] sCharArray = s.toCharArray();
        ans += sCharArray.length;
        for (int axis = 0; axis < s.length(); axis++) {
            int orbit = 1;
            int length = 1;
            while (axis - orbit >= 0 && axis + orbit < s.length()) {
                if (sCharArray[axis - orbit] == sCharArray[axis + orbit]) {
                    orbit = orbit + 1;
                    length = length + 2;
                    ans++;
                } else {
                    break;
                }
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
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }

    private static int countSubstringsBrute(String s) {
        int totalPalindromeSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(i, j, s)) totalPalindromeSubstring++;
            }
        }
        return totalPalindromeSubstring;
    }

    private static boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
