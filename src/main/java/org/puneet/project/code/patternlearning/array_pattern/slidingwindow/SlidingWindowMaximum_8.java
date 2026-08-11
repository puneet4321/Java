package org.puneet.project.code.patternlearning.array_pattern.slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum_8 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
//        int[] ints = maxSlidingWindowBrute(nums, k);
        int[] ints = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int fillRes = 0;
        int[] result = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int r = 0; r < n; r++) {
            // add into pq
            pq.offer(new int[]{nums[r], r});
            //window start after first k - 1 element into pq
            if (r >= k - 1) {
                while (pq.peek()[1] <= r - k) {
                    pq.poll();
                }
                result[fillRes] = pq.peek()[0];
                fillRes++;
            }
        }
        return result;
    }


    public static int[] maxSlidingWindowBrute(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < k + i; j++) {
                max = Math.max(max, nums[j]);
            }
            result[i] = max;
        }
        return result;
    }
}
