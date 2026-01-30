package org.puneet.project.code.arrays;

import java.util.ArrayList;
import java.util.List;

public class Intersection_6 {
    // Intersection : Elements present in both arrays
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 3, 4, 5};
        int[] arr2 = {1 , 2, 3, 4, 5, 5, 6};

        intersectionOfArrays(arr1, arr2);

    }

    private static void intersectionOfArrays(int[] arr1, int[] arr2) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                intersection.add(arr1[i]);
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else j++;
        }
        System.out.println(intersection);
    }
}
