package org.puneet.project.code.patternlearning.intervals.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class N_MeetingsinOneRoom_1 {
    public static void main(String[] args) {
        int start[] = {0, 3, 1, 5, 5, 8};
        int end[] = {5, 4, 2, 9, 7, 9};
        ArrayList<Integer> maxMeeting = maxMeetings(start, end);
        System.out.println(maxMeeting.toString());

    }

    public static ArrayList<Integer> maxMeetings(int[] start, int[] end) {
        ArrayList<Integer> result = new ArrayList<>();
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            Meeting m = new Meeting(start[i], end[i], i + 1);
            meetings.add(m);
        }
        // have sorted meetings on end time.
        meetings.sort(
                Comparator.comparingInt((Meeting meeting) -> meeting.end).thenComparing(meeting -> meeting.position)
        );
        int totalMeeting = 1;
        int freeTime = meetings.get(0).end;
        result.add(meetings.get(0).position);
        for (int i = 1; i < meetings.size(); i++) {
            Meeting currentMeeting = meetings.get(i);
            if (currentMeeting.start > freeTime) {
                totalMeeting++;
                freeTime = currentMeeting.end;
                result.add(currentMeeting.position);
            }
        }
        return result;
    }

    static class Meeting {
        int start;
        int end;
        int position;

        public Meeting(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "start=" + start +
                    ", end=" + end +
                    ", position=" + position +
                    '}';
        }
    }
}
