package org.puneet.project.code.arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class RemoveAllZeros_4 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3, 0, 0, 0, 4, 5, 7, 0, 0, 8};
//        removeZeroBruteForce(arr);
        removeZeroOptimal(arr);

    }

    private static void removeZeroOptimal(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        System.out.println(j);
        System.out.println(Arrays.toString(arr));
    }

    private static void removeZeroBruteForce(int[] arr) {
        LinkedList<Integer> nonZeroElements = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                nonZeroElements.add(arr[i]);
            }
        }
        int i = 0;
        for (Integer nonZeroElement : nonZeroElements) {
            arr[i] = nonZeroElement;
            i++;
        }
        System.out.println(Arrays.toString(arr));
        int nonZeroElementSize = nonZeroElements.size();
        for (int j = nonZeroElementSize; j < arr.length; j++) {
            arr[j] = 0;
        }
        System.out.println("Final output array: " + Arrays.toString(arr));
    }
}
