package org.puneet.project.code.arrays;

public class PascalTriangle_17 {
    public static void main(String[] args) {
//         This is pascal triangle.
       /*        1
                1 1
               1 2 1
              1 3 3 1
             1 4 6 4 1
       */
//        Question 1 : Print element at a given index in a pascal triangle
        findElementInPascalTriangle(10, 3);
    }

    private static void findElementInPascalTriangle(int row, int column) {
        // Consider the pascal triangle above.
        // There is formula for finding out the element and That is how to find out combination.
        int res = 1;
        for (int i = 0; i < column; i++) {
            res = res * (row - i);
            res = (res / (i + 1));
        }
        System.out.println("Element is : " + res);
    }


}
