package org.puneet.project.code.arrays;

import java.util.*;

public class UnionOfTwoSortedArrays_5 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 5};
        int[] arr2 = {2, 3, 4, 5, 5, 6};

//        unionOfTwoSortedArrayBruteForce(arr, arr2);
        unionOfTwoSortedArrayOptimal(arr, arr2);

    }

    private static void unionOfTwoSortedArrayOptimal(int[] arr, int[] arr2) {
        int i = 0;
        int j = 0;
        ArrayList<Integer> unionArray = new ArrayList<>();
        while (i < arr.length && j < arr2.length) {
            if (arr[i] <= arr2[j]) {
                if (unionArray.isEmpty() || unionArray.get(unionArray.size() - 1) != arr[i]) { // TO Prevent Duplicate and using arrays sorted property
                    unionArray.add(arr[i]);
                }
                i++;
            } else {
                if (unionArray.isEmpty() || unionArray.get(unionArray.size() - 1) != arr2[j]) {
                    unionArray.add(arr2[j]);
                }
                j++;
            }
        }

        while (i < arr.length) {
            if (unionArray.isEmpty() || unionArray.get(unionArray.size() - 1) != arr[i]) { // TO Prevent Duplicate and using arrays sorted property
                unionArray.add(arr[i]);
            }
            i++;
        }
        while (j < arr2.length) {
            if (unionArray.isEmpty() || unionArray.get(unionArray.size() - 1) != arr2[j]) { // TO Prevent Duplicate and using arrays sorted property
                unionArray.add(arr2[j]);
            }
            j++;
        }

        System.out.println(unionArray);
    }

    public static void unionOfTwoSortedArrayBruteForce(int[] arr, int[] arr2) {
        Set<Integer> union = new HashSet<>();
        for (int a : arr) {
            union.add(a);
        }

        for (int a : arr2) {
            union.add(a);
        }
        System.out.println(union.toString());
    }
}
