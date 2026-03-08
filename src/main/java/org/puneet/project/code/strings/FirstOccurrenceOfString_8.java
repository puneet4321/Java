package org.puneet.project.code.strings;

public class FirstOccurrenceOfString_8 {
    public static void main(String[] args) {
        String heyStack = "sadbutsad";
        String needle = "sad";
        int occurrence = firstOccurrence(heyStack, needle);
        System.out.println("occurrence : " + occurrence);
    }

    private static int firstOccurrence(String heyStack, String needle) {
        int occurrence = 0;
        occurrence = heyStack.indexOf(needle);
        return occurrence;
    }
}
