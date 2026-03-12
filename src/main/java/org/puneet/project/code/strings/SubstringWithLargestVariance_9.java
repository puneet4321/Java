package org.puneet.project.code.strings;

public class SubstringWithLargestVariance_9 {
    public static void main(String[] args) {
        String str = "ababab";
        int largestVariance = largestVariance(str);
        System.out.println("Largest variance : " + largestVariance);
    }

    public static int largestVariance(String str) {
        int result = 0;
        // storing elements which are present in our string
        boolean[] allChars = new boolean[26];
        for (char ch : str.toCharArray()) {
            allChars[ch - 'a'] = true;
        }

        for (char firstChar = 'a'; firstChar <= 'z'; firstChar++) {
            for (char secondChar = 'a'; secondChar <= 'z'; secondChar++) {
                if (firstChar != secondChar && allChars[firstChar - 'a'] && allChars[secondChar - 'a']) {
                    int firstCharCount = 0;
                    int secondCharCount = 0;
                    boolean previouslyFoundSecond = false;
                    for (char ch : str.toCharArray()) {
                        if (ch == firstChar) {
                            firstCharCount++;
                        } else if (ch == secondChar) {
                            secondCharCount++;
                        }
                        // If both char has appeared once
                        if (secondCharCount > 0) {
                            result = Math.max(result, firstCharCount - secondCharCount);
                        } else if (previouslyFoundSecond) {
                            result = Math.max(result, firstCharCount - 1);
                        }
                        // If negative
                        if (secondCharCount > firstCharCount) {
                            firstCharCount = 0;
                            secondCharCount = 0;
                            previouslyFoundSecond = true;
                        }
                    }
                }
            }
        }
        System.out.println("result : " + result);
        return result;
    }
}
