package org.puneet.project.code.strings;

import java.util.Arrays;

public class StringCompression_1 {
    public static void main(String[] args) {
//        char[] charArray = new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        char[] charArray = new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b'};
        char[] charArray = new char[]{'a','b'};
        int compressedStrLen = stringCompression(charArray);
        System.out.println(compressedStrLen);
    }

    private static int stringCompression(char[] charArray) {
        int n = charArray.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            char currChar = charArray[i];
            int currCharCount = 0;
            while (i < n && currChar == charArray[i]) {
                currCharCount++;
                i++;
            }
            //Do the assignment work
            charArray[j] = currChar;
            j++;
            if (currCharCount > 1) {
                char[] countInStr = String.valueOf(currCharCount).toCharArray();
                System.out.println("countInStr " + Arrays.toString(countInStr));
                for (char k : countInStr) {
                    charArray[j] = k;
                    j++;
                }
            }
        }
        System.out.println("char array : " + Arrays.toString(charArray));
        return j;
    }
}
