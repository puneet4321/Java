package recursion.easy;

public class EasyQuestion {
    static int counter = 0 ;
    public static void main(String[] args) {
        noOfStepsToZeroDigit(7);

        System.out.println(noOfStepsToZeroDigitWithoutStaticVariable(8));
    }
    static void noOfStepsToZeroDigit(int num){
        // Take a num and we have to return in how many steps it will be zero.if no. is odd -1, if even -2
        // This approach is a cheating we have used a static variable outside
        if (num==0) {
            System.out.println(counter);
            return;
        }
        if(num%2 == 0 ) {
            counter++;
            noOfStepsToZeroDigit(num - 2);
        }
        if (num%2 != 0){
            counter++;
            noOfStepsToZeroDigit(num-1);
        }
    }
    static int noOfStepsToZeroDigitWithoutStaticVariable(int num){
        int temp = 0;
        return helper(num, temp);
    }
    static int helper(int num, int temp){
        if (num==0){
            return temp;
        }
        if(num%2==0){
            ++temp;
           return helper(num-2,temp);
        }
            ++temp;
           return helper(num-1,temp);
    }
}
