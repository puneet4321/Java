package org.puneet.project.code.strings;

import java.util.HashSet;
import java.util.List;

public class ALike_6 {
    static HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static void main(String[] args) {
        String s = "Book";
        boolean isAlike = isStringAlike(s);
        System.out.println("isAlike " + isAlike);
    }

    private static boolean isStringAlike(String s) {
        boolean isALike = false;
        if ((s.length() % 2) != 0) {
            System.out.println("length is not even ");
            return isALike;
        }
        String strFirstHalf = s.substring(0, (s.length() / 2));
        String strSecondHalf = s.substring((s.length() / 2) , s.length());
        System.out.println(strFirstHalf);
        System.out.println(strSecondHalf);
        int count  = 0 ;
        int count1  = 0 ;
        for(Character ch : strFirstHalf.toCharArray()) {
            if (vowels.contains(ch)) count++;
        }
        for(Character ch : strSecondHalf.toCharArray()) {
            if (vowels.contains(ch)) count1++;
        }
        if(count == count1) {
            System.out.println("alike ");
            isALike = true;
        }
        return isALike;
    }
}
