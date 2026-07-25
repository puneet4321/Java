package org.puneet.project.code.patternlearning.binarysearch.classicalBS;

public class SqrtOfx_2 {
    public static void main(String[] args) {
        int sqrt = mySqrt(8);
        System.out.println(sqrt);
    }

    public static int mySqrt(int x) {
        if (x < 2) return x;
        long left = 1;
        long right = x / 2;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long square = mid * mid;
            if (square == x) return (int) mid;
            else if (square < x) left = mid + 1;
            else if (square > x) right = mid - 1;
        }
        return (int) right;
    }
}
