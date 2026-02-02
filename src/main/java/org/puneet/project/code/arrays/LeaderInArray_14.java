package org.puneet.project.code.arrays;

import java.util.ArrayList;
import java.util.List;

public class LeaderInArray_14 {
    public static void main(String[] args) {
        //All elements on the right should be smaller
        int[] arr = {10, 22, 12, 3, 0, 6};
        List<Integer> leaders = leaderInArrayBrute(arr);
        System.out.println("leaders: " + leaders);
        List<Integer> leadersOptimal = leaderInArrayOptimal(arr);
        System.out.println("leaders in optimal solution : " + leaders);
    }

    private static List<Integer> leaderInArrayOptimal(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int rightMax = Integer.MIN_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > rightMax) {
                rightMax = arr[i];
                leaders.add(rightMax);
            }
        }
        return leaders;
    }

    private static List<Integer> leaderInArrayBrute(int[] arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isLeader = true;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] <= arr[j]) {
                    System.out.println("here");
                    isLeader = false;
                    break;
                }
            }
            if (isLeader) result.add(arr[i]);
        }
        Integer last = arr[arr.length - 1];
        result.add(last);
        return result;
        // As you see in code. We make maximum on the right array. Basically we have maintain maximum on the right.
    }
}
