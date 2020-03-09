package leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: slwhy
 * @date: 2019/10/10
 * @description: num 123
 */
public class MaxProfit3 {
    public static int maxProfit_22(int[] prices) {
        //这个代码是leetcode上给出的思路，并不能运行
        //题解 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/#comment
        int n = prices.length;
        int max_k = 2;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) { /*处理 base case */ }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];

    }

    public static int maxProfit_21(int[] prices) {
        //dp 解法，没想到
        //题解 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/#comment
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE;
        int dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    public static int maxProfit_2(int[] prices) {
        // 这个解法有问题，每次下降就卖出，不能保证该次交易获利最大，比如说 [1,2,4,2,5,7,2,4,9,0]，代码结果为12，正确应该为 13
        if (prices.length < 1) return 0;
        boolean isBuy = false;//手上是否有股票
        ArrayList<Integer> res = new ArrayList<Integer>();
        int buyPrice = 0;//买入时的价格
        int sellPrice = 0;
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
                res.add(prices[i] - buyPrice);
            }
            if (isBuy && i == prices.length - 2) {
                res.add(prices[i + 1] - buyPrice);
            }
        }
        Collections.sort(res);
        if (res.size() < 1) return 0;
        if (res.size() == 1) return res.get(0);
        return res.get(res.size() - 1) + res.get(res.size() - 2);
    }
}
