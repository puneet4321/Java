package org.puneet.project.code.patternlearning.hashmap;

import java.util.HashMap;
import java.util.Objects;

public class RansomNote_2 {
    public static void main(String[] args) {
        System.out.println("canConstruct :" + canConstruct("aa", "ab"));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        boolean canConstruct = false;
        HashMap<Character, Integer> mapofMagazine = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            mapofMagazine.put(ch, mapofMagazine.getOrDefault(ch, 0) + 1);
        }
        int sizeOfRansomNote = 0;
        for (char ch : ransomNote.toCharArray()) {
            if (Objects.nonNull(mapofMagazine.get(ch)) && mapofMagazine.get(ch) > 0 && sizeOfRansomNote < ransomNote.length()) {
                mapofMagazine.put(ch, mapofMagazine.get(ch) - 1);
                sizeOfRansomNote++;
            } else if (Objects.isNull(mapofMagazine.get(ch))) {
                break;
            }
        }
        if (sizeOfRansomNote == ransomNote.length()) {
            canConstruct = true;
        }
        return canConstruct;
    }

    public boolean canConstructOptimal(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        //[0,0,0,....,0]
        int[] magazineFrequencies = new int[26];

        for (char c : magazine.toCharArray()) {
            magazineFrequencies[c - 'a']++;
        }
        //[0,1,0....]

        for (char c : ransomNote.toCharArray()) {
            magazineFrequencies[c - 'a']--; //[-1 , 1 ..]
            if (magazineFrequencies[c - 'a'] < 0) return false;
        }

        return true;
    }
}
