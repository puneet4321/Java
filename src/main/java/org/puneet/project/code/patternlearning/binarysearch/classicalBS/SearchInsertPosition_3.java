package org.puneet.project.code.patternlearning.binarysearch.classicalBS;

public class SearchInsertPosition_3 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 7;
        int targetIdx = searchInsert(nums, target);
        System.out.printf("Target idx : " + targetIdx);
    }

    public static int searchInsert(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;

            if (arr[mid] < target) low = mid + 1;
            else if (arr[mid] > target) high = mid - 1;
        }
        return high + 1;
    }
}
