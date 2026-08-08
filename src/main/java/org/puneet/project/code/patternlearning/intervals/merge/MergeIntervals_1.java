package org.puneet.project.code.patternlearning.intervals.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_1 {
    public static void main(String[] args) {
        // Sample overlapping/non-overlapping intervals to merge.
        int[][] intervals = {{1, 3}, {2, 6}, {8, 9}, {9, 11}, {8, 10}, {2, 4}, {15, 18}, {16, 17}};
        // Call merge and store the final non-overlapping intervals.
        int[][] mergedIntervals = mergeBrute(intervals);
        int[][] mergedIntervalsOptimal = merge(intervals);
        // Print the merged result for verification.
        System.out.println(Arrays.deepToString(mergedIntervalsOptimal));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (ans.isEmpty()) {
                ans.add(intervals[i]);
            }
            // check if can be merged. if yeh merge the interval
            if (intervals[i][0] <= ans.get(ans.size() - 1)[1]) {
                int[] lastInterval = ans.get(ans.size() - 1);
                int lastIntervalFirst = lastInterval[0];
                int lastIntervalSecond = Math.max(lastInterval[1], intervals[i][1]);
                lastInterval = new int[]{lastIntervalFirst, lastIntervalSecond};
                ans.set(ans.size() - 1, lastInterval);
            } else {
                ans.add(intervals[i]);
            }
        }

        int[][] mergedIntervals = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            mergedIntervals[i] = ans.get(i);
        }
        return mergedIntervals;
    }


    public static int[][] mergeBrute(int[][] intervals) {
        // Sort by start ascending; if starts are equal, sort by end ascending.
        // Example: [2,6] and [2,4] become [2,4] then [2,6].
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        // Holds the merged intervals we have finalized so far.
        List<int[]> result = new ArrayList<>();

        // Visit every interval as a potential start of a new merged group.
        for (int i = 0; i < intervals.length; i++) {
            // Start of the current candidate interval.
            int first = intervals[i][0];
            // End of the current candidate interval; may grow while merging ahead.
            int last = intervals[i][1];

            // If we already have at least one merged interval in result...
            if (!result.isEmpty()) {
                // Pick the most recently added merged interval.
                int[] lastValidInterval = result.get(result.size() - 1);
                // Start of that previous merged interval (currently unused).
                int firstOfLastValidInterval = lastValidInterval[0];
                // End of that previous merged interval.
                int lastOfLastValidInterval = lastValidInterval[1];

                // Because intervals are sorted by start, if current end is still
                // inside the previous merged end, current interval was already absorbed.
                // Example: previous=[1,6], current=[2,4] => 4 <= 6 => skip.
                if (last <= lastOfLastValidInterval) {
                    // Move to the next i; do not create a duplicate merged interval.
                    continue;
                }
            }

            // Look ahead from the next interval to absorb all overlaps into [first, last].
            // When i is the last index, j starts at length and this loop body never runs.
            for (int j = i + 1; j < intervals.length; j++) {
                // Start of the ahead interval.
                int firstOfJ = intervals[j][0];
                // End of the ahead interval.
                int lastOfJ = intervals[j][1];

                // Overlap/touch condition: ahead starts before or at current merged end.
                // Example: current end=3, ahead=[2,6] => 2 <= 3 => merge.
                if (firstOfJ <= last) {
                    // Extend the merged end to cover the farther end.
                    // Example: max(3, 6) => 6, so interval becomes [1,6].
                    last = Math.max(last, lastOfJ);
                } else {
                    // Ahead starts after current end, so no more merges are possible
                    // from this group (later intervals start even farther because of sort).
                    break;
                }
            }

            // Current group is fully expanded; store the merged [first, last].
            result.add(new int[]{first, last});
        }

        // Convert List<int[]> into a fixed 2D array of size [mergedCount][2].
        int[][] mergedIntervals = new int[result.size()][2];
        // Copy each merged interval from the list into the array.
        for (int i = 0; i < result.size(); i++) {
            // Assign the i-th merged interval reference into the result array.
            mergedIntervals[i] = result.get(i);
        }
        // Return all non-overlapping merged intervals.
        return mergedIntervals;
    }
}
