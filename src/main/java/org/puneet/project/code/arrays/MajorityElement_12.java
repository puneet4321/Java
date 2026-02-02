package org.puneet.project.code.arrays;

import java.util.HashMap;

public class MajorityElement_12 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 3, 1, 2, 2};

        majorityElementBruteForce(arr);
        majorityElementBetter(arr);
        //Moone votings algo.
        majorityElementOptimal(new int[]{7, 7, 5, 7, 5, 1, 5, 7, 5, 5, 7, 7, 5, 5, 5, 5});
    }

    private static void majorityElementOptimal(int[] arr) {
        int counter = 0;
        int majorityEle = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (counter == 0) {
                majorityEle = arr[i];
                counter++;
            } else if (counter > 0 && majorityEle == arr[i]) {
                counter++;
            } else if (counter > 0 && majorityEle != arr[i]) {
                counter--;
            }
        }
        if (counter == 0) {
            System.out.println("No Majority element");
        } else if (counter > 0) {
            System.out.println("Majority element in optimal is " + majorityEle);
        }
    }

    private static void majorityElementBetter(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Fill the hashmap
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) > arr.length / 2) {
                System.out.println("The majority element is " + key);
                return;
            }
        }
        System.out.println("No majority element found");
    }

    private static void majorityElementBruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int potential = arr[i];
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == potential) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                System.out.println("MAJORITY ELEMENT : " + potential);
                return;
            }
        }
        System.out.println("No MAJORITY ELEMENT");
    }
}
