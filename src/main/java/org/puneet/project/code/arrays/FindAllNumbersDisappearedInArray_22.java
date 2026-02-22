package org.puneet.project.code.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllNumbersDisappearedInArray_22 {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> disappearedNums = findAllNumbersDisappearedInArray(arr);
        System.out.println("disappearedNums : " + disappearedNums);
    }

    private static List<Integer> findAllNumbersDisappearedInArray(int[] arr) {
        List<Integer> disappearedNums = new LinkedList<>();
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < arr.length; i++) {
//            set.add(arr[i]);
//        }
//        for (int i = 1; i <= arr.length; i++) {
//            if(!set.contains(i)) {
//                disappearedNums.add(i);
//            }
//        }
//        System.out.println(disappearedNums);

        for (int i = 0; i < arr.length; i++) {
            int ele = Math.abs(arr[i]);
            int idx = ele - 1;
            arr[idx] = -Math.abs(arr[idx]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                disappearedNums.add(i + 1);
            }
        }
        System.out.println(Arrays.toString(arr));
        return disappearedNums;
    }
}
