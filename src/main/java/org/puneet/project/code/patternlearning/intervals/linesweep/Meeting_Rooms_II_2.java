package org.puneet.project.code.patternlearning.intervals.linesweep;

import java.util.Map;
import java.util.TreeMap;

public class Meeting_Rooms_II_2 {
    public static void main(String[] args) {
        int start[] = {1, 10, 7};
        int end[] = {4, 15, 10};
        System.out.println(minMeetingRooms(start, end));
    }

    public static int minMeetingRooms(int[] start, int[] end) {
        Map<Integer, Integer> events = new TreeMap<>();
        for (int i = 0; i < start.length; i++) {
            events.put(start[i], events.getOrDefault(start[i], 0) + 1);
            events.put(end[i], events.getOrDefault(end[i], 0) - 1);
        }
        int overlap = 0;
        int maxOverlaps = 0;
        for (Map.Entry<Integer, Integer> entry : events.entrySet()) {
            Integer val = entry.getValue();
            overlap += val;
            maxOverlaps = Math.max(overlap, maxOverlaps);
        }
        return maxOverlaps;
    }
}
