package org.puneet.project.code.arrays;

import java.util.*;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 1, 4, 2, 3};
//        int[] arr = {2, 0, 0, 3}; // for array containing zeros edge case.
        int k = 4;
        longestSubArrayWithSumKBrute(arr, k);
        longestSubArrayWithSumKBrutenn(arr, k);
        longestSubArrayWithSumKBetter(arr, k); // there is a optimal solution for if arr consists +ve and 0 only. using sliding windows approach
        longestSubArrayWithSumKSlidingWindow(arr, k);
    }

    private static void longestSubArrayWithSumKSlidingWindow(int[] arr, int k) {
        int right = 0;
        int left = 0;
        int maxLength = 0;
        int preFixSum = 0;
        while (right < arr.length) {
            preFixSum += arr[right];
            if (preFixSum == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
            while (left <= right && preFixSum > k) {
                preFixSum -= arr[left];
                left++;
                if (preFixSum == k) {
                    maxLength = Math.max(maxLength, right - left + 1);
                }
            }
            right++; // It's always increasing as window always increment.
        }
        System.out.println("Max length for optimal solution is " + maxLength);
    }

    private static void longestSubArrayWithSumKBetter(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // sum as value , index as key
        int preFixSum = 0;
        int maxLength = 0;
//        k = 3
        for (int i = 0; i < arr.length; i++) {
            preFixSum += arr[i];
            if (!map.containsKey(preFixSum)) {
                map.put(preFixSum, i);
            }
            if (preFixSum == k) { // Initially when sum is K
                maxLength = Math.max(maxLength, i + 1);
            }
            if (preFixSum > k) {
                int remaining = preFixSum - k;
                if (map.containsKey(remaining)) {
                    int previousOccurrence = map.get(remaining);
                    // (i - previousOccurrence) = > aaj ki Occurrence -  previousOccurrence ;
                    maxLength = Math.max(maxLength, i - previousOccurrence);
                }
            }
        }
        // This solution is best if array contains +ve, -ve and 0. There is a edge case also covered in case if array contains 0.
//        the only thing is need to be done is only put in map when it's not contains in map.
        System.out.println("Longest subArray with sum " + k + " is " + maxLength);
    }

    private static void longestSubArrayWithSumKBrute(int[] arr, int sumK) {
        int longest = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int num = 0;
                for (int k = i; k < j; k++) {
                    num += arr[k];
                }
                if (num == sumK) {
                    longest = Math.max(num, j - i + 1);
                    System.out.println("Longest Sub Array With Sum K in loop : " + longest);
                }
            }
        }
        // Time Complexity ( n*n*n ). we can reduce it to n*2
        System.out.println("Longest Sub Array With Sum K : " + longest);
    }

    private static void longestSubArrayWithSumKBrutenn(int[] arr, int sumK) {
        int longest = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int num = 0;
            for (int j = i + 1; j < arr.length; j++) {
                num += arr[j];
                if (num == sumK) {
                    longest = Math.max(num, j - i + 1);
                    System.out.println("Longest Sub Array With Sum K in loop : " + longest);
                }
            }
        }
        // Time Complexity ( n*n ).but there is more optimal solution.
        System.out.println("Longest Sub Array With Sum K : " + longest);
    }
}
