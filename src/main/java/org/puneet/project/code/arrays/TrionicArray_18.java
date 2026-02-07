package org.puneet.project.code.arrays;

public class TrionicArray_18 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 5, 7};
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {3, 2, 1};
        int[] arr3 = {3, 2, 1, 2, 3};

        System.out.println("isTrionic " + trionicArray(arr3));
    }

    private static boolean trionicArray(int[] arr) {
        int i = 0;
//        boolean isTrionic = false;
        while ((i < arr.length - 1) && arr[i] < arr[i + 1]) {
            i++;
        }
        // if array is only increasing, and we reach the end of array.
        if (i == 0 || i == arr.length - 1) {
            return false;
        }

        while (i < arr.length - 1 && arr[i] > arr[i + 1]) {
            i++;
        }
        // array is decreasing and reach the end.
        if (i == arr.length - 1) {
            return false;
        }

        while (i < arr.length - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        return i == arr.length - 1;
    }
}
