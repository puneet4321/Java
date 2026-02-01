package org.puneet.project.code.arrays;

public class NumberAppearOneTime_8 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4};
        numberAppearOneTimeBruteForce(arr);
        numberAppearOneTimeOptimal(arr);
    }

    private static void numberAppearOneTimeOptimal(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        System.out.println("numberAppearOneTimeOptimal: " + xor);
    }

    public static void numberAppearOneTimeBruteForce(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int num = arr[i];
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && num == arr[j]) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("numberAppearOneTimeBruteForce : " + num);
            }
        }
    }
}
