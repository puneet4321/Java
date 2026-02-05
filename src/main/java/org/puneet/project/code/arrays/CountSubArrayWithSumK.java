package org.puneet.project.code.arrays;

import java.util.HashMap;

public class CountSubArrayWithSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -3, 1, 1, 1, 4, 2, -3};

        countSubArrayWithSumK(arr, 3);
    }

    private static void countSubArrayWithSumK(int[] arr, int k) {
        int preSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // key = preSum , value = how many times it occured
        map.put(0, 1); // pre sum 0 is Persent 1 time.
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            // check in hm after subtracting k
            int remaining = preSum - k;
            if (map.containsKey(remaining)) {
                count++;
                map.put(remaining, map.get(remaining) + 1);
            }
            if (!map.containsKey(remaining)) {
                map.put(preSum, 1);
            }

        }
        System.out.println("array with sum :  "  + k + " present " + count + " times");
    }
}
