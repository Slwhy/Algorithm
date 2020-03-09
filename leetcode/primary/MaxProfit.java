package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/7
 * @description: 买卖股票的最佳时机 II
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        /**
         * @Author slwhy
         * @Date 2020/3/7
         * @Param [prices]
         * @return int
         * @Description 这题做过，涨则买入，降则卖出
         **/
        boolean has = false;
        int cost = 0, get = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (!has && prices[i + 1] > prices[i]) {
                cost = cost + prices[i];
                has = true;
                continue;
            }
            if (has && prices[i + 1] < prices[i]) {
                get = get + prices[i];
                has = false;
            }
        }
        if (has) get = get + prices[prices.length - 1];
        return get - cost;
    }
}
