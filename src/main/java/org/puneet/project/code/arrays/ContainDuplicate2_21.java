package org.puneet.project.code.arrays;

import java.util.HashMap;

public class ContainDuplicate2_21 {
    public static void main(String[] args) {
        System.out.println(containDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containDuplicate(new int[]{1, 0, 1, 1}, 1));
//        System.out.println(containDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    private static boolean containDuplicate(int[] arr, int k) {
        boolean result = false;
        HashMap<Integer, Integer> persistIndexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (persistIndexMap.containsKey(arr[i])) {
                int previousOcc = persistIndexMap.get(arr[i]);
                int length = Math.abs(i - previousOcc);
                if (length <= k) {
                    result = true;
                    return result;
                }
            }
            persistIndexMap.put(arr[i], i);
        }
        return result;
    }
}
