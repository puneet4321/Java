package org.puneet.project.code.patternlearning.intervals.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval_2 {
    public static void main(String[] args) {
        int[] newInterval = {4, 8};
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[][] mergedInterval = insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(mergedInterval));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length) {
            // Case 1: current interval ends before newInterval starts => no overlap.
            // Example: [1,2] and newInterval [4,8] => 2 < 4, so keep [1,2] as-is.
            if (intervals[i][1] < newInterval[0]) {
                // Add this fully-left interval into the result.
                result.add(intervals[i]);
            }
            // Case 2: current interval starts after newInterval ends => no more overlaps possible.
            // Example: [12,16] and newInterval [4,8] => 12 > 8, so stop scanning.
            else if (intervals[i][0] > newInterval[1]) {
                // Break so remaining intervals are appended after newInterval later.
                break;
            }
            // Case 3: intervals overlap (or touch) newInterval, so absorb into newInterval.
            // Example: [3,5] overlaps [4,8] => expand to [3,8], then [6,7]/[8,10] too.
            else {
                // Expand start to the leftmost overlapping start.
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                // Expand end to the rightmost overlapping end.
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
            i++;
        }
        // Insert the (possibly expanded) newInterval into its correct place.
        result.add(newInterval);
        for (int j = i; j < intervals.length; j++) {
            result.add(intervals[j]);
        }
        return result.toArray(new int[result.size()][]);
    }

}
