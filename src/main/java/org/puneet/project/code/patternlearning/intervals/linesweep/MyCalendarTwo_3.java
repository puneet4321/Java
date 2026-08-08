package org.puneet.project.code.patternlearning.intervals.linesweep;

import java.util.TreeMap;

public class MyCalendarTwo_3 {
    private final TreeMap<Integer, Integer> events = new TreeMap<>();

    public boolean book(int startTime, int endTime) {
        addEvent(startTime, 1);
        addEvent(endTime, -1);

        int activeBookings = 0;
        for (int change : events.values()) {
            activeBookings += change;
            if (activeBookings > 2) {
                // Revert the tentative booking before reporting failure.
                addEvent(startTime, -1);
                addEvent(endTime, 1);
                return false;
            }
        }
        return true;
    }

    private void addEvent(int time, int change) {
        int updatedChange = events.getOrDefault(time, 0) + change;
        if (updatedChange == 0) {
            events.remove(time);
        } else {
            events.put(time, updatedChange);
        }
    }

/**
 * Your MyCalendarTwo_3 object will be instantiated and called as such:
 * MyCalendarTwo_3 obj = new MyCalendarTwo_3();
 * boolean param_1 = obj.book(startTime,endTime);
 */
}
