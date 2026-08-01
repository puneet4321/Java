package org.puneet.project.code.patternlearning.binarysearch.bsOnAnswer;

import java.util.Arrays;

public class AggressiveCows_4 {
    public static void main(String[] args) {
        int [] cows = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println(aggressiveCows(cows, k));
    }

    public static int aggressiveCows(int[] stable, int cows) {
        Arrays.sort(stable);
        int low = 1;
        int ans = low;
        int high = stable[stable.length - 1] - stable[0];
        while (low <= high) {
            int midDist = low + (high - low) / 2;
            if (placeCows(stable, midDist, cows)) {
                ans = midDist;
                low = midDist + 1;
            } else high = midDist - 1;
        }
        return ans;
    }

    /**
     * Checks if we can place {@code totalCows} cows in sorted stalls {@code arr}
     * such that the minimum distance between any two cows is at least {@code midDist}.
     * Greedy: place next cow in the leftmost stall that satisfies the distance.
     */
    public static boolean placeCows(int[] arr, int midDist, int totalCows) {
        // Place the 1st cow in the first stall (always safe / optimal start).
        int cow = 1;
        // Position (stall coordinate) of the most recently placed cow.
        int lastCowPlaced = arr[0];
        // Try remaining stalls from left to right.
        for (int i = 1; i < arr.length; i++) {
            // Distance from last placed cow to current stall is enough?
            if (arr[i] - lastCowPlaced >= midDist) {
                // Place another cow here.
                cow++;
                // Update last placement so next cows are measured from here.
                lastCowPlaced = arr[i];
            }
            // Else skip this stall — too close to the previous cow.
        }
        // Feasible if we managed to place at least as many cows as required.
        if (cow >= totalCows) {
            return true;
        }
        // Could not place all cows with this minimum distance.
        return false;
    }
}
