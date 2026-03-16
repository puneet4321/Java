package org.puneet.project.code.strings;

public class DecodedStringAtIndex_11 {
    public static void main(String[] args) {
        String str = "xy22";
//        String res = decodeAtIndexBrute(str, 5);
        String res1 = decodeAtIndex(str, 5);
        System.out.println("Result : " + res1);
    }

    private static String decodeAtIndex(String str, int k) {
        String res = "";
        long size = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                size = size * Integer.parseInt(String.valueOf(ch));
            } else if (Character.isLetter(ch)) {
                size++;
            }
        }
        System.out.println("size of array " + size);
        // reverse loop on string
        for (int i = str.length() - 1; i >= 0; i--) {
            k = (int) (k % size);
            if (k == 0 && Character.isLetter(str.charAt(i))) {
                return String.valueOf(str.charAt(i));
            }
            if (Character.isDigit(str.charAt(i))) {
                size = size / Integer.parseInt(String.valueOf(str.charAt(i)));
            } else {
                size--;
            }
        }
        return res;
    }

    // This solution will not word as
    private static String decodeAtIndexBrute(String str, int k) {
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                res = res + ch;
            } else {
                Integer intValOfCh = Integer.valueOf(String.valueOf(ch));
                System.out.println(intValOfCh);
                res = res.repeat(intValOfCh);
            }
        }
        System.out.println(res);
        return String.valueOf(res.charAt(k - 1));
    }
}
