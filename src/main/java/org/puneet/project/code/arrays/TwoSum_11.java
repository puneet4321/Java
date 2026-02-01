package org.puneet.project.code.arrays;

import java.util.HashMap;

public class TwoSum_11 {
    public static void main(String[] args) {
        int[] arr = {2, 6, 5, 8, 11};
//        twoSumBrute(arr, 14);
        twoSumOptimalSortedArray(arr, 14);
        twoSumOptimal(arr, 14); // This solution is best for unsorted array.

    }

    private static void twoSumOptimalSortedArray(int[] arr, int twoSum) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum == twoSum) {
                System.out.println(low + " " + high + " " + arr[low] + " " + arr[high]);
                return;
            }
            low++ ;
            high--;
        }
    }

    private static void twoSumOptimal(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // putting elements in array.
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
            int remaining = sum - arr[i];
            if (map.containsKey(remaining)) {
                System.out.println("Two sum found at index " + map.get(remaining) + " and " + i);
                return;
            }

        }
    }

    private static void twoSumBrute(int[] arr, int sum) {
        // (n*n) approach
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] + arr[j] == sum) {
                    System.out.println("Two sum found and Elements are :  " + arr[i] + " " + arr[j]);
                    return;
                }
            }
        }
    }
}
