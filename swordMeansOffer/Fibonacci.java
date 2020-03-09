package swordMeansOffer;

/**问题：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）n<=39
 * */

public class Fibonacci {
    public static int Fibonacci(int n) {
        int num1,num2,res;
        num1 = 1;
        num2 = 1;
        res = 1;
        if (n==0){
            return 0;
        }
        if (n<=2){
            return 1;
        }
        while (n>2){
            res = num1+num2;
            num1 = num2;
            num2 = res;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci(5));

    }
}
