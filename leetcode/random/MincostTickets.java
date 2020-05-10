package leetcode.random;


/**
 * @author: slwhy
 * @date: 2020/5/6
 * @description: 983. 最低票价
 */
public class MincostTickets {

    int cost = Integer.MAX_VALUE;
    int[] terms = new int[]{1, 7, 30};

    public int mincostTickets(int[] days, int[] costs) {
        /**
         * @Author slwhy
         * @Date 2020/5/6
         * @Param [days, costs]
         * @return int
         * @Description 参照leetcode方法1写的，从前往后dp
         **/
        int lent = days.length, maxDay = days[lent - 1], minDay = days[0];
        int[] dp = new int[maxDay + 1];
        int index = 0;
        for (int d = 1; d <= maxDay; d++) {
            int min = Integer.MAX_VALUE;
            if (d == days[index]) {
                min = d - terms[2] >= 0 ? Math.min(min, dp[d - terms[2]] + costs[2]) : Math.min(min, costs[2]);
                min = d - terms[1] >= 0 ? Math.min(min, dp[d - terms[1]] + costs[1]) : Math.min(min, costs[1]);
                min = Math.min(min, dp[d - 1] + costs[0]);
                dp[d] = min;
                index++;
            } else dp[d] = dp[d - 1];
        }
        return dp[maxDay];
    }

    public int mincostTickets1(int[] days, int[] costs) {
        /**
         * @Author slwhy
         * @Date 2020/5/6
         * @Param [days, costs]
         * @return int
         * @Description leetcode 上的解法，从后往前dp
         **/
        int len = days.length, maxDay = days[len - 1], minDay = days[0];
        int[] dp = new int[maxDay + 31]; // 多扩几天，省得判断 365 的限制
        // 只需看 maxDay -> minDay，此区间外都不需要出门，不会增加费用
        for (int d = maxDay, i = len - 1; d >= minDay; d--) {
            // i 表示 days 的索引
            // 也可提前将所有 days 放入 Set，再通过 set.contains() 判断
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                i--; // 别忘了递减一天
            } else dp[d] = dp[d + 1]; // 不需要出门
        }
        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
    }

    public void helper(int[] days, int index, int[] costs, int hasCost) {
        /**
         * @Author slwhy
         * @Date 2020/5/6
         * @Param [days, index, costs, hasCost]
         * @return void
         * @Description 回溯+剪枝,不过会超时
         **/
        if (index == days.length && hasCost <= cost) {
            cost = hasCost;
        } else if (hasCost < cost) {
            for (int i = 0; i < costs.length; i++) {
                int step = index;
                while (step < days.length && days[step] < days[index] + terms[i]) step++;
                helper(days, step, costs, hasCost + costs[i]);
            }
        }
    }

    public static void main(String[] args) {
        MincostTickets mincostTickets = new MincostTickets();
        System.out.println(mincostTickets.mincostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15}));
    }

}
