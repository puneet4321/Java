package org.puneet.project.code.patternlearning.binarysearch.bsOnAnswer;

import java.util.Arrays;

public class CapacitytoShipPackageswithinDDays_2 {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = 5;
//        int shipInDays = shipWithinDaysBrute(weights, days);
        int shipInDays = shipWithinDays(weights, days);
        System.out.println(shipInDays);
    }

    public static int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        int ans = high;
        while (low <= high) {
            int midCap =  low + (high - low) / 2;
            int daysRequired = daysRequiredToShip(weights, midCap);
            if (daysRequired <= days) {
                ans = midCap;
                high = midCap - 1;
            } else low = midCap + 1;
        }
        return ans;
    }

    public static int shipWithinDaysBrute(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();
        int ans = high;
        for (int cap = low; cap <= high; cap++) {
            int daysRequired = daysRequiredToShip(weights, cap);
            if (daysRequired <= days) {
                ans = cap;
                return ans;
            }
        }
        return ans;
    }

    private static int daysRequiredToShip(int[] weights, int cap) {
        int load = 0;
        int totalDaysReq = 1;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] + load > cap) {
                totalDaysReq++;
                load = weights[i];
            } else load += weights[i];
        }
        return totalDaysReq;
    }

}
