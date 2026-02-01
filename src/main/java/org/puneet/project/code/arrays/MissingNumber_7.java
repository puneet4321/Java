package org.puneet.project.code.arrays;

import java.util.Arrays;

public class MissingNumber_7 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5};
//        missingNumberBetter(arr);
        missingNumberOptimal(arr);
    }

    private static void missingNumberOptimal(int[] arr) {
        // using sum of n number property
        int sum = 0;
        int n = arr[arr.length - 1];
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
        int sumOfN = (n * (n + 1)) / 2;
        System.out.println(sumOfN);
        System.out.println("Mising no : " + (sumOfN - sum));
    }

    private static void missingNumberBetter(int[] arr) {
        // using hashing technique. will hash all the elements of arr
        int missingNO = Integer.MIN_VALUE;
        int max = arr[arr.length - 1];
        int[] hashArr = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            hashArr[arr[i]] = 1;
        }
        for (int i = 1; i < hashArr.length; i++) {
            if (hashArr[i] == 0) {
                missingNO = i;
                break;
            }
        }
        System.out.println("Missing no. is : " + missingNO);
        // Complexity is : ( n+ n )
    }

}
