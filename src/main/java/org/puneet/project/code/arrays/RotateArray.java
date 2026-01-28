package org.puneet.project.code.arrays;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {

        // rotating by one
        // This code works fine for one element. what if we need to rotate k elements.
        int[] arr = {1, 2, 3, 4, 5};
        int rotatedElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = rotatedElement;
        System.out.println(Arrays.toString(arr));


    }
}
