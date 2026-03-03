package org.puneet.project.code.strings;

import java.util.ArrayList;
import java.util.List;

public class MakeTheStringGreat_5 {
    public static void main(String[] args) {
        String str = "leEeetCode";
        String grateString = makeTheStringGreat(str);
        System.out.println(grateString);
    }

    private static String makeTheStringGreat(String str) {
        List<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            if (list.isEmpty()) {
                list.add(character);
            } else if (list.get(list.size() - 1) - 32 == character || list.get(list.size() - 1) + 32 == character) {
                list.remove(list.size() - 1);
            } else {
                list.add(character);
            }
        }
        String result = "";
        for (Character character : list) {
            result += character;
        }
        return result;
    }
}
