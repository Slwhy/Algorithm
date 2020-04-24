package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/23
 * @description: 面试题 08.11. 硬币
 */
public class WaysToChange {
    public int waysToChange(int n) {
        if (n < 1) return 0;
        int[] steps = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int step : steps) {
            for (int i = step; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - step]) % 1000000007;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        WaysToChange waysToChange = new WaysToChange();
        System.out.println(waysToChange.waysToChange(10));
    }
}
