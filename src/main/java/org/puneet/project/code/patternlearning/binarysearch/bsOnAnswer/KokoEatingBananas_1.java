package org.puneet.project.code.patternlearning.binarysearch.bsOnAnswer;

import java.util.Arrays;

public class KokoEatingBananas_1 {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println(minEatingSpeedBrute(piles, h));
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int high = Arrays.stream(piles).max().getAsInt();
        int ans = high;
        int low = 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long requiredTime = requiredTime(piles, mid);
            if (requiredTime <= h) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return ans;
    }

    // This brute force will give TLE on large inputs (O(max(piles) * n))
    public static int minEatingSpeedBrute(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();
        for (int speed = 1; speed <= max; speed++) {
            if (requiredTime(piles, speed) <= h) {
                return speed;
            }
        }
        return max; // speed = max always finishes in piles.length hours
    }

    public static long requiredTime(int[] piles, int speed) {
        long totalHours = 0;
        for (int bananasInPile : piles) {
            totalHours += ((long) bananasInPile + speed - 1) / speed;
        }
        return totalHours;
    }
}
