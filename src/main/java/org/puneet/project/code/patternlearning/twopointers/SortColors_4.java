package org.puneet.project.code.patternlearning.twopointers;

import java.util.Arrays;

public class SortColors_4 {
    public static void main(String[] args) {
        int[] zerosOnesTows = {1, 1, 2, 2, 1, 1, 0, 0, 0, 2};
        //sortColorsBrute(zerosOnesTows);
        sortColors(zerosOnesTows);
        System.out.println(Arrays.toString(zerosOnesTows));
    }

    //Dutch National Flag Algo
    // 0 to low -1 ==> 0's
    // low to mid -1 ==> 1's
    // high + 1 to arr.length - 1 ==> 2's

    // So, the unsorted part od array is mid to high
    private static void sortColors(int[] zerosOnesTows) {
        int low = 0, mid = 0;
        int high = zerosOnesTows.length - 1;
        while (mid <= high) {
            if (zerosOnesTows[mid] == 0) {
                // shift zero to the low part
                swap(zerosOnesTows, low, mid);
                low++;
                mid++;
            } else if (zerosOnesTows[mid] == 1) {
                mid++;
            } else if (zerosOnesTows[mid] == 2) {
                swap(zerosOnesTows, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // (n+n) complexity
    private static void sortColorsBrute(int[] zerosOnesTows) {
        int zeros = 0;
        int ones = 0;
        int tows = 0;
        for (int i = 0; i < zerosOnesTows.length; i++) {
            if (zerosOnesTows[i] == 0) {
                zeros++;
            }
            if (zerosOnesTows[i] == 1) {
                ones++;
            }
            if (zerosOnesTows[i] == 2) {
                tows++;
            }
        }
        int i = 0;
        while (zeros > 0) {
            zerosOnesTows[i] = 0;
            i++;
            zeros--;
        }
        while (ones > 0) {
            zerosOnesTows[i] = 1;
            i++;
            ones--;
        }
        while (tows > 0) {
            zerosOnesTows[i] = 2;
            i++;
            tows--;
        }
    }

}
