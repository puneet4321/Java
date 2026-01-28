package org.puneet.project.code.arrays;

import java.util.Arrays;

public class SecondLargest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 7, 7, 5};
//        secondLargestBruteForce(arr);
//        secondLargestBetter(arr);
        secondLargestOptimal(arr);
    }

    public static void secondLargestBruteForce(int[] arr) {
        //        ( n log n  ) solution
        // Brute force
        Arrays.sort(arr);
        int largest = arr[arr.length - 1];
        int slargest = Integer.MIN_VALUE;

        for (int i = arr.length - 2; i > 0; i--) {
            if (arr[i] != largest) {
                slargest = arr[i];
                break;
            }
        }
        System.out.println(" Second largest = " + slargest);
    }

    public static void secondLargestBetter(int[] arr) {
//        ( n+n ) solution
        // Better solution : How to think if we can eliminate the sorting.
//        Arrays.sort(arr);
        int largest = Integer.MIN_VALUE;
        int slargest = Integer.MIN_VALUE;

        // From first pass find out the largest.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        // from second pass find out the second largest.
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > slargest && arr[i] != largest) {
                slargest = arr[i];
            }
        }

        System.out.println(" Largest = " + largest);
        System.out.println(" Second largest = " + slargest);
    }

    public static void secondLargestOptimal(int[] arr) {
        // We are taking two passes ( n+n ). Let's see if we can reduce this.
        // Solution in single pass. ( n ) . Two pointer or tow variable approach. will take two variable and update while looping arr.
        int largest = arr[0];
        int slargest = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                slargest = largest;
                largest = arr[i];
            } else if (arr[i] < largest && arr[i] > slargest) {
                slargest = arr[i];
            }
        }
        System.out.println(" Second largest = " + slargest);
        System.out.println(" largest = " + largest);
    }
}
