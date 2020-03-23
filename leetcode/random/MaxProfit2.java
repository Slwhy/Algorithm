package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/10/10
 * @description: num 122
 */
public class MaxProfit2 {
    public static int maxProfit3(int[] prices) {
        //dp解法，没想到，是根据leetcode上别人的代码复现的
        if (prices.length < 1) return 0; //如果不加这个判断，如果prices为空，后面取prices[0]会报错
        int lent = prices.length;
        //dp状态转义矩阵，dp[i][0]表示第i天不持有股票，dp[i][1]表示第i天持有股票
        //第i天不持有股票，有两种情况，一是第i-1天也不持有股票；二是第i-1天持有股票，在第i天卖出
        //第i天持有股票，有两种情况，一是第i-1天也持有股票，二是第i-1天不持有股票，在第i天买入
        int[][] dp = new int[lent][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < lent; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[lent - 1][0];
    }

    public static int maxProfit2(int[] prices) {
        //贪心解法
        //每次涨的时候，当天买进，第二天卖出
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }

    public static int maxProfit(int[] prices) {
        //一句话，涨买入，降卖出
        boolean isBuy = false;//手上是否有股票
        int max = 0;//当前最大收益
        int buyPrice = 0;//买入时的价格
        for (int i = 0; i < prices.length - 1; i++) {
            if (!isBuy && prices[i] > prices[i + 1]) {
                continue;
            }
            if (!isBuy && prices[i] < prices[i + 1]) {
                isBuy = true;
                buyPrice = prices[i];
            }
            if (isBuy && prices[i] > prices[i + 1]) {
                isBuy = false;
                max = max + prices[i] - buyPrice;
            }
            if (isBuy && i == prices.length - 2) {
                max = max + prices[i + 1] - buyPrice;
            }
        }
        return max;
    }
}
