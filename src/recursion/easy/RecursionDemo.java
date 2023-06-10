package recursion.easy;

import java.util.Scanner;

public class RecursionDemo {
    public static void main(String[] args) {
        // factorial program
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int factorialResult = factorial(num);
        int fibonacciResult = fibonacci(num);
        System.out.println("factorial of num is " + factorialResult);
        System.out.println("fibonacci of num is " + fibonacciResult);
    }
    public static int factorial(int num){
        if( num == 1) {
        return 1;
        }
        return num * factorial(num - 1) ;
    }

    public static int fibonacci (int num) {
        if (num<2) return num;
        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}
