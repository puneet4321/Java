package org.puneet.project.code.arrays;

public class SearchInsertPosition_19 {
    public static void main(String[] args) {
        int[] arr = {2, 7, 8, 9, 10};
        int target = 3;
        int pos = searchInsertPosition(arr, target);
        System.out.println("Insert Position is : " + pos);
    }

    private static int searchInsertPosition(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                System.out.println("mid : " + mid);
                return mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        System.out.println("start " + start);
        System.out.println("end " + end);

        return start;
    }
}
