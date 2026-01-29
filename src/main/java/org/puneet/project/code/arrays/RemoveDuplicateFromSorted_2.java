package org.puneet.project.code.arrays;

import java.util.Arrays;

public class RemoveDuplicateFromSorted_2 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4, 5};
        removeDuplicate(arr);
    }

    public static void removeDuplicate(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                arr[i + 1] = arr[j];
                i = i + 1;
            }
        }
        System.out.println("No. of unique elements : " + (i + 1));
        System.out.println(Arrays.toString(arr));
    }
}


