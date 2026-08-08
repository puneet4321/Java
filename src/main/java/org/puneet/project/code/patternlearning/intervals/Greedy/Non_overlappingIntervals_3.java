package org.puneet.project.code.patternlearning.intervals.Greedy;

import java.util.*;

public class Non_overlappingIntervals_3 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int totalOverlappingIntervals = eraseOverlapIntervals(intervals);
        System.out.println(totalOverlappingIntervals);
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        int overlappingIntervals = 1;
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[1]));
        int lastFreeTime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (lastFreeTime <= intervals[i][0]) {
                overlappingIntervals++;
                lastFreeTime = intervals[i][1];
            }
        }
        return intervals.length - overlappingIntervals;
    }

}
