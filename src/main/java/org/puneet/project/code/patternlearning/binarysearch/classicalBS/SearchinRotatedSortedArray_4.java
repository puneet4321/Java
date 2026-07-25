package org.puneet.project.code.patternlearning.binarysearch.classicalBS;

public class SearchinRotatedSortedArray_4 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // Left sorted half ( >= covers mid == left, e.g. [3,1] )
            if (nums[mid] >= nums[left]) {
                // check if target lies in this sorted half and move
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else left = mid + 1;
            }
            // right sorted half
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else right = mid - 1;
            }
        }
        return -1;
    }
}
