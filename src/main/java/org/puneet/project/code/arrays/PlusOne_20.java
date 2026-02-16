package org.puneet.project.code.arrays;

import java.util.Arrays;

public class PlusOne_20 {
    public static void main(String[] args) {
        plusOne(new int[]{1, 9, 9});

    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                System.out.println("Arrays after increment one :  " + Arrays.toString(digits));
                return digits;
            } else if (digits[i] == 9) {
                digits[i] = 0;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        System.out.println("Arrays after increment one :  " + Arrays.toString(result));
        return digits;
    }
}
