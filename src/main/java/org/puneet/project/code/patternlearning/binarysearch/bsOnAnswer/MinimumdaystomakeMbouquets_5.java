package org.puneet.project.code.patternlearning.binarysearch.bsOnAnswer;

public class MinimumdaystomakeMbouquets_5 {
    public static void main(String[] args) {
        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        int m = 2;
        int k = 3;
        System.out.println(minDays(bloomDay, m, k));
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        // Not enough flowers to make m bouquets of k adjacent flowers each
        if ((long) m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int bloom : bloomDay) {
            low = Math.min(low, bloom);
            high = Math.max(high, bloom);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (possibleToMakeBouquets(bloomDay, m, k, mid)) {
                ans = mid;          // mid works → try an earlier day
                high = mid - 1;
            } else {
                low = mid + 1;      // mid too early → need more days
            }
        }
        return ans;
    }

    public static boolean possibleToMakeBouquets(int[] bloomDay, int noOfBouquets, int minAdjacentFlowers, int midDays) {
        int count = 0;       // consecutive bloomed flowers so far
        int bouquetMade = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= midDays) {
                count++;
            } else {
                // streak broken — convert consecutive bloomed flowers into bouquets
                bouquetMade += count / minAdjacentFlowers;
                count = 0;
            }
        }
        bouquetMade += count / minAdjacentFlowers; // leftover streak at the end
        return bouquetMade >= noOfBouquets;
    }
}
