package leetcode.medium;

import java.math.BigInteger;

/**
 * @author: slwhy
 * @date: 2020/4/16
 * @description: 62. 不同路径
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        /**
         * @Author slwhy
         * @Date 2020/4/17
         * @Param [m, n]
         * @return int
         * @Description leetcode 上的思路，dp解法
         **/
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];

    }

    public int uniquePaths1(int m, int n) {
        /**
         * @Author slwhy
         * @Date 2020/4/17
         * @Param [m, n]
         * @return int
         * @Description 自己想出来的，排列组合解法
         **/
        m = m - 1;
        n = n - 1;
        if (m == 0 || n == 0) return 1;
        return (factorial(m + n).divide(factorial(m)).divide(factorial(n))).intValue();
    }

    public BigInteger factorial(Integer n) {
        if (n == 1) return new BigInteger("1");
        else return factorial(n - 1).multiply(new BigInteger(n.toString()));
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        uniquePaths.uniquePaths(3, 2);
    }
}
