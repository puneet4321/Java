package org.puneet.project.code.patternlearning.stack.monotonic;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement_1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};
//        ArrayList<Integer> nextGreaterArray = nextLargerElementBrute(arr);
        ArrayList<Integer> nextGreaterArray = nextLargerElement(arr);
        System.out.println(nextGreaterArray);
    }

    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        ArrayList<Integer> nextGreaterArray = new ArrayList<>();
        for (int i = 0 ; i < arr.length ; i++) {
            nextGreaterArray.add(-1);
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] >= stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty() && arr[i] < stack.peek()) {
                nextGreaterArray.set(i, stack.peek());
            }
            stack.push(arr[i]);
        }
        return nextGreaterArray;
    }

    public static ArrayList<Integer> nextLargerElementBrute(int[] arr) {
        ArrayList<Integer> nextGreaterArray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int next = -1;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[i]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println(next);
            nextGreaterArray.add(next);
        }
        return nextGreaterArray;
    }
}
