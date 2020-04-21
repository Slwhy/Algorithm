package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: slwhy
 * @date: 2020/4/17
 * @description: 322. 零钱兑换
 */
public class CoinChange {
    int count = Integer.MAX_VALUE;

    HashMap<Integer, Integer> memory = new HashMap<>();

    public int coinChange(int[] coins, int amount) {
        /**
         * @Author slwhy
         * @Date 2020/4/20
         * @Param [coins, amount]
         * @return int
         * @Description leetcode上的dp解法，不熟练
         * 题解：https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-tao-lu-xiang-jie-by-wei-lai-bu-ke/
         **/
        if (coins.length < 1) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        return memoryDfs(coins, amount);
    }

    public int memoryDfs(int[] coins, int remains) {
        /**
         * @Author slwhy
         * @Date 2020/4/20
         * @Param [coins, remains]
         * @return int
         * @Description leetcode 上的解法，带备忘录的自顶向下递归
         **/
        if (remains < 0) return -1;
        if (remains == 0) return 0;
        else {
            if (memory.keySet().contains(remains)) return memory.get(remains);
            int res = Integer.MAX_VALUE;
            int subRes;
            for (int i : coins) {
                subRes = memoryDfs(coins, remains - i);
                if (subRes >= 0) res = Math.min(res, subRes + 1);
            }
            if (res == Integer.MAX_VALUE) res = -1;
            memory.put(remains, res);
            return res;
        }
    }

    public int coinChange1(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public void dfs(int[] coins, int index, int remains, int num) {
        /**
         * @Author slwhy
         * @Date 2020/4/20
         * @Param [coins, index, remains, num]
         * @return void
         * @Description 回溯+剪枝, i + num < count 这个是剪枝的关键部分
         **/
        if (remains == 0 && count > num) count = num;
        if (index >= 0 && remains > 0) {
            for (int i = remains / coins[index]; i >= 0 && i + num < count; i--) {
                dfs(coins, index - 1, remains - (i * coins[index]), num + i);
            }
        }
    }
}
