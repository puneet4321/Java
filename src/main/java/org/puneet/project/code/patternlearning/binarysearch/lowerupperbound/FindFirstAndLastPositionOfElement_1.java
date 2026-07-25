package org.puneet.project.code.patternlearning.binarysearch.lowerupperbound;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElement_1 {
    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] firstLast = searchRange(nums, target);
        System.out.println("firstLast: " + Arrays.toString(firstLast));
    }

    public static int[] searchRange(int[] nums, int target) {
        boolean firstOccurrence = true;
        int first = findOccurrence(nums, target, firstOccurrence);
        int last = findOccurrence(nums, target, !firstOccurrence);
        return new int[]{first, last};
    }

    public static int findOccurrence(int[] nums, int target, boolean firstOccurrence) {
        int low = 0;
        int high = nums.length - 1;
        int occurrence = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                occurrence = mid;
                if (firstOccurrence) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return occurrence;
    }

}
