package org.puneet.project.code.patternlearning.intervals.linesweep;

import java.util.Map;
import java.util.TreeMap;

public class MaximumPopulationYear_1 {
    public static void main(String[] args) {
        int[][] logs = {{1993, 1999}, {2000, 2010}};
        int maxAliveYear = maximumPopulation(logs);
        System.out.println(maxAliveYear);
    }

    public static int maximumPopulation(int[][] logs) {
        int maxAliveYear = 0;
        int max = 0 ;
        int year = 0 ;
        Map<Integer, Integer> events = new TreeMap<>();
        for (int i = 0; i < logs.length; i++) {
            events.put(logs[i][0], events.getOrDefault(logs[i][0], 0) + 1);
            events.put(logs[i][1], events.getOrDefault(logs[i][1], 0) - 1);
        }
        for (Map.Entry<Integer, Integer> entry : events.entrySet()) {
            maxAliveYear += entry.getValue();
            if (maxAliveYear > max) {
                max = maxAliveYear;
                year = entry.getKey();
            }
        }
        return year;
    }
}
