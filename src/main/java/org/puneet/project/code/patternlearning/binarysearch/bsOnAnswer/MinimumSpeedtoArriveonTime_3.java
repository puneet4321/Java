package org.puneet.project.code.patternlearning.binarysearch.bsOnAnswer;

public class MinimumSpeedtoArriveonTime_3 {
    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        double hour = 2.7;
        int minSpeed = minSpeedOnTime(dist, hour);
        System.out.println(minSpeed);
    }

    public static int minSpeedOnTime(int[] dist, double hour) {
        int low = 1;
        int high = (int) 1e7;
        int ans = -1;
        while (low <= high) {
            int midSpeed = low + (high - low) / 2;
            double timeTaken = timeTaken(dist, midSpeed);
            if (timeTaken <= hour) {
                ans = midSpeed;
                high = midSpeed - 1;
            } else low = midSpeed + 1;
        }
        return ans;
    }

    public static double timeTaken(int[] dist, int midSpeed) {
        double time = 0.0;
        for (int i = 0; i < dist.length; i++) {
            double t = (double) dist[i] / midSpeed;
            if (i != dist.length - 1) {
                time += Math.ceil(t);
            } else time += t;
        }
        return time;
    }
}

