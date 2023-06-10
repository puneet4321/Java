package recursion.easy;

public class CountZeros {
    public static void main(String[] args) {
        System.out.println(zerosCount(302040));
    }
    static int zerosCount(int num){
        return helper(num,0);
    }

    private static int helper(int num, int i) {
        //Without using static varible
        if (num==0){
            return i;
        }
        if (num%10 == 0){
            return helper(num/10,++i);
        }
        return helper(num/10,i);
    }
}
