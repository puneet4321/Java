package org.puneet.project.code.strings;

import java.util.Arrays;

public class Pangram_2 {
    public static void main(String[] args) {
        String s = "The quick brown fox jumps over the lazy dog";
        boolean isPangram = validPangram(s);
        System.out.println( " is pangram "+ isPangram);
    }

    private static boolean validPangram(String s) {
        boolean isPangram = true;
        int [] visited = new int[26];
        char[] charArray = s.toCharArray();
        for(char ch : charArray) {
            if(ch >= 'a' &&  ch <= 'z') {
                int i = ch - 'a';
                visited[i] ++ ;
            }
        }
        System.out.println( "Visited : " + Arrays.toString(visited));
        for(int vis : visited) {
            if(vis == 0) {
                isPangram = false;
                break;
            }
        }
        return isPangram;
    }
}
