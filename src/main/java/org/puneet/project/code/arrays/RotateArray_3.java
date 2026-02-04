package org.puneet.project.code.arrays;

import java.util.Arrays;

public class RotateArray_3 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        // rotating by one
//        rotateArrayByOne(arr);
        // This code works fine for one element. what if we need to rotate k elements. But this is not optimal solution.
//        rotateArrayByk(arr, 2);
        rotateArrayBykOptimalCode(arr, 2);

    }

    private static void rotateArrayBykOptimalCode(int[] arr, int k) {
        int low = 0;
        int high = k - 1;
        //Rotate till O to k-1 partition
        reverseArray(arr, low, high);
        System.out.println(Arrays.toString(arr));
        high = k;
        //Rotate till k to last partition
        reverseArray(arr, high, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        //Rotate whole array
        reverseArray(arr, 0, arr.length - 1);
        System.out.println("Final rotated array " + Arrays.toString(arr));

    }

    public static void reverseArray(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    private static void rotateArrayByOne(int[] arr) {
        int rotatedElement = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = rotatedElement;
        System.out.println(Arrays.toString(arr));
    }

    private static void rotateArrayByk(int[] arr, int k) {
//        int[] arr = {1, 2, 3, 4, 5};
        int n = arr.length;
        k = k % n;
        System.out.println("No of rotations : " + k);

        int[] tempArray = new int[k];
        for (int i = 0; i < k; i++) {
            tempArray[i] = arr[i];
        }
        // shifting of elements
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }
        System.out.println(Arrays.toString(arr));

//        place elements in tempArray to original arr.
        int j = 0;
        for (int i = n - k; i < n; i++) {
            arr[i] = tempArray[j];
            j++;
        }
        System.out.println(Arrays.toString(arr));
    }

}
