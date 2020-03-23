package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/10/8
 * @description: num 121
 * 区间求差问题，可以转换为连续子数组求和问题，参考如下链接
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/121-mai-mai-gu-piao-de-zui-jia-shi-ji-dp-7-xing-ji/
 */
public class MaxProfit {


    public int maxProfit2(int[] prices) {
        /**
         * @Author slwhy
         * @Date 2019/10/8
         * @Param [prices]
         * @return int
         * @Description leetcode上的DP解法, 没想出来
         * 记录【今天之前买入的最小值】
         * 计算【今天之前最小值买入，今天卖出的获利】，也即【今天卖出的最大获利】
         * 比较【每天的最大获利】，取最大值即可
         **/
        if (prices.length <= 1)
            return 0;
        int min = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        /**
         * @Author slwhy
         * @Date 2019/10/8
         * @Param [prices]
         * @return int
         * @Description 暴力
         **/
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                max = prices[j] - prices[i] > max ? prices[j] - prices[i] : max;
            }
        }
        return max;
    }


}
