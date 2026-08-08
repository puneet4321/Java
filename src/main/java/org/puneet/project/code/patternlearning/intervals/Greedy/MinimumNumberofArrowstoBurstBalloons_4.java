package org.puneet.project.code.patternlearning.intervals.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberofArrowstoBurstBalloons_4 {
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {10, 16},
                {2, 8},
                {1, 6},
                {7, 12}
        };
        int arrows = findMinArrowShots(points);
        System.out.println(arrows);
    }

    public static int findMinArrowShots(int[][] points) {
        int minArrows = 1;
        Arrays.sort(points, Comparator.comparingInt((int[] a) -> a[0]));
        System.out.println(Arrays.deepToString(points));
        int[][] prevInterval = new int[1][2];
        prevInterval[0] = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > prevInterval[0][1]) {
                minArrows++;
                prevInterval[0][0] = points[i][0];
                prevInterval[0][1] = points[i][1];
            } else {
                prevInterval[0][0] = Math.max(prevInterval[0][0], points[i][0]);
                prevInterval[0][1] = Math.min(prevInterval[0][1], points[i][1]);
            }
        }
        return minArrows;
    }
}
