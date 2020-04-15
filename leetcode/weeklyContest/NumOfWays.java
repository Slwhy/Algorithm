package leetcode.weeklyContest;


/**
 * @author: slwhy
 * @date: 2020/4/12
 * @description: 1411. 给 N x 3 网格图涂色的方案数
 */
public class NumOfWays {

    public int numOfWays(int n) {
        long count = 0;
        long num1 = 6;
        long num2 = 6;
        long tmp1;
        long tmp2;
        for (int i = 1; i <= n; i++) {
            count = num1 + num2;
            tmp1 = num1;
            tmp2 = num2;
            num1 = (3 * tmp1 + 2 * tmp2)%1000000007;
            num2 = (2 * tmp1 + 2 * tmp2)%1000000007;
        }
        return (int) (count%(1000000007));
    }


    public static void main(String[] args) {
        NumOfWays numOfWays = new NumOfWays();
        System.out.println(numOfWays.numOfWays(3));
        System.out.println(Integer.MAX_VALUE > (Math.pow(10, 9) + 7));
    }
}
