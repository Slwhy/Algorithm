package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/6/3
 * @description: 837. 新21点
 */
public class New21Game {

    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0;
        double[] dp = new double[K + W];
        for (int i = K; i < K + W && i <= N; i++) {
            dp[i] = 1.0;
        }
        dp[K - 1] = 1.0 * Math.min(W, N - K + 1) / W;

        for (int i = K - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + (dp[i + 1] - dp[i + 1 + W]) / W;
        }
        return dp[0];
    }

    public double new21Game1(int N, int K, int W) {
        /**
         * @Author slwhy
         * @Date 2020/6/3
         * @Param [N, K, W]
         * @return double
         * @Description leetcode 上dp思路
         **/
        if (K == 0) return 1.0;
        double[] dp = new double[K + W];
        for (int i = K; i <= N && i < K + W; i++) {
            dp[i] = 1.0;
        }
        for (int i = K - 1; i >= 0; i--) {
            for (int j = 1; j <= W; j++) {
                dp[i] += dp[i + j];
            }
            dp[i] = dp[i] / W;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        New21Game new21Game = new New21Game();
        System.out.println(new21Game.new21Game(21, 17, 10));
    }
}
