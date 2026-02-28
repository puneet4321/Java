package org.puneet.project.code.strings;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRoman_3 {
    public static HashMap<String, Integer> romanMap = new LinkedHashMap<>();

    static {
        romanMap.put("M", 1000);
        romanMap.put("CM", 900);
        romanMap.put("D", 500);
        romanMap.put("CD", 400);
        romanMap.put("C", 100);
        romanMap.put("XC", 90);
        romanMap.put("L", 50);
        romanMap.put("XL", 40);
        romanMap.put("X", 10);
        romanMap.put("IX", 9);
        romanMap.put("V", 5);
        romanMap.put("IV", 4);
        romanMap.put("I", 1);
    }

    public static void main(String[] args) {
        Integer num = 1994 ; //58;
        java.lang.String roman = integerToRoman(num);
        System.out.println(roman);
    }

    private static String integerToRoman(Integer num) {
        StringBuilder roman = new StringBuilder();
        while (num > 0) {
            String romanInput = "";
            Integer divisor = 0;
            for (Map.Entry<String, Integer> val : romanMap.entrySet()) {
                if (val.getValue() <= num) {
                    romanInput = val.getKey();
                    divisor = val.getValue();
                    break;
                }
            }
            Integer times = num / divisor;
            for (int i = 0; i < times; i++) {
                roman.append(romanInput);
            }
            Integer remain = num % divisor;
            num = remain;
        }
        return roman.toString();
    }

}
