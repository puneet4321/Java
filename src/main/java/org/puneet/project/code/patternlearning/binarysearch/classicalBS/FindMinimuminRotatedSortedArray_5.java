package org.puneet.project.code.patternlearning.binarysearch.classicalBS;

public class FindMinimuminRotatedSortedArray_5 {
    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        int target = 1;
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) { // Right array is sorted. mid can and cannot be the ans. {4 1 2 3} mid is ans. {5 0 1 2 3 4} mid is not the ans .
                r = mid;
            } else { // Right array is not sorted.
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
