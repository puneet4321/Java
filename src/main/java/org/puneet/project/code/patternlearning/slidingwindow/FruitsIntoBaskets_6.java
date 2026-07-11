package org.puneet.project.code.patternlearning.slidingwindow;

import java.util.HashMap;

public class FruitsIntoBaskets_6 {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 3, 2, 2};
//        int len = totalFruitBrute(fruits);
        int maxLengthWithTwoFruits = totalFruit(fruits);
        System.out.println(maxLengthWithTwoFruits);
    }

    private static int totalFruit(int[] fruits) {
        int maxLengthWithTwoFruits = 0;
        int left = 0;
        HashMap<Integer, Integer> mapContainsTwoFruitsAtMax = new HashMap<>();
        for (int r = 0; r < fruits.length; r++) {
            mapContainsTwoFruitsAtMax.put(fruits[r], mapContainsTwoFruitsAtMax.getOrDefault(fruits[r], 0) + 1);
            // shrinking phase
            while (mapContainsTwoFruitsAtMax.size() > 2) {
                mapContainsTwoFruitsAtMax.put(fruits[left], mapContainsTwoFruitsAtMax.get(fruits[left]) - 1);
                if (mapContainsTwoFruitsAtMax.get(fruits[left]) == 0) {
                    mapContainsTwoFruitsAtMax.remove(fruits[left]);
                }
                left++;
            }
            maxLengthWithTwoFruits = Math.max(maxLengthWithTwoFruits, r - left + 1);
        }
        return maxLengthWithTwoFruits;
    }

    public static int totalFruitBrute(int[] fruits) {
        int totalFruitCount = 0;
        for (int l = 0; l < fruits.length; l++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int countPerIteration = 0;
            for (int r = l; r < fruits.length; r++) {
                map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
                // two baskets are filled
                if (map.size() > 2) {
                    break;
                }
                countPerIteration++;
            }
            totalFruitCount = Math.max(totalFruitCount, countPerIteration);
        }
        return totalFruitCount;
    }
}
