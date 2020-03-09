package leetcode;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/8
 * @description: 322. 零钱兑换
 */
public class CoinChange {
    public int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinChangeCore(coins, amount, 0, coins.length - 1);
        if (res == Integer.MAX_VALUE) return -1;
        else return res;
    }


    public void coinChangeCore(int[] coins, int amount, int count, int i) {
        /**
         * @Author slwhy
         * @Date 2020/3/8
         * @Param [coins, amount, count, i]
         * @return void
         * @Description 贪心解法
         **/
        if (amount == 0) res = Math.min(count, res);
        if (amount > 0 && i >= 0) {
            if (amount == coins[i]) res = Math.min(count + 1, res);
            for (int n = amount / coins[i]; n >= 0 && count + n < res; n--) {
                coinChangeCore(coins, amount - n * coins[i], count + n, i - 1);
            }
        }
    }

    public static void main(String[] args) {
        CoinChange coin = new CoinChange();
        int [] array = new int[]{2};
        System.out.println(coin.coinChange(array,3));
    }
}
