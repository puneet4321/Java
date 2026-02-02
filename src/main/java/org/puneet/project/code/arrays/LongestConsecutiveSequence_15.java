package org.puneet.project.code.arrays;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence_15 {
    public static void main(String[] args) {
        int[] arr = {102, 4, 100, 1, 101, 3, 2, 1, 1};
        int[] arr2 = {100, 102, 100, 101, 101,5, 4, 3, 2, 3, 2, 1, 1, 1, 2};
        int lengthOfConsecutiveSequence = longestConsecutiveSequenceBruteForce(arr);
        System.out.println("Longest consecutive sequence : " + lengthOfConsecutiveSequence);
        int lengthOfConsecutiveSequenceBetter = longestConsecutiveSequenceBetter(arr2);
        System.out.println("Longest consecutive sequence better: " + lengthOfConsecutiveSequenceBetter);
        int lengthOfConsecutiveSequenceOptimal = longestConsecutiveSequenceOptimal(arr2);
        System.out.println("Longest consecutive sequence optimal : " + lengthOfConsecutiveSequenceOptimal);
    }

    private static int longestConsecutiveSequenceOptimal(int[] arr) {
        int longest = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        for (Integer setValue : set) {
            int remaining = setValue - 1;
            int counter = 0;
            if (!set.contains(remaining)) {
                while (set.contains(setValue)) {
                    counter++;
                    setValue = setValue + 1;
                }
                longest = Math.max(counter, longest);
            }
        }
        return longest;
    }

    private static int longestConsecutiveSequenceBetter(int[] arr) {
        int longestSequence = 1;
        Arrays.sort(arr);
//        [1, 1, 1, 2, 2, 2, 3, 3, 4, 100, 100, 101, 101, 102]
        System.out.println(Arrays.toString(arr));
        int counter = 1;
        int lastSmaller = arr[1];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - 1 == lastSmaller) {
                counter++;
                lastSmaller = arr[i];
            } else if (arr[i] != lastSmaller) {
                counter = 1;
                lastSmaller = arr[i];
            }
            longestSequence = Math.max(counter, longestSequence);
        }
        return longestSequence;
    }

    private static int longestConsecutiveSequenceBruteForce(int[] arr) {
        int longestSequence = 1;
        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            int n = arr[i];
            while (linearSearch(arr, n + 1)) {
                n = n + 1;
                count++;
            }
            longestSequence = Math.max(count, longestSequence);
        }
        return longestSequence;
    }

    public static boolean linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return true;
            }
        }
        return false;
    }
}
