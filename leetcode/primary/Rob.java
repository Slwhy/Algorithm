package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/19
 * @description: 198. 打家劫舍
 */
public class Rob {

    public int rob(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/19
         * @Param [nums]
         * @return int
         * @Description dp[i] nums长度为i+1,获得的最大收益,和下面方法中是dp意义不同
         **/
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public int rob2(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/19
         * @Param [nums]
         * @return int
         * @Description dp的意思盗取了nums[i]之后获取的最大收益, dp[i] 最后盗取的一家一定是num[i]
         **/
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[0] + nums[2];
        int max = Math.max(dp[2], dp[1]);
        for (int i = 3; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
            max = Math.max(dp[i], dp[i - 1]);
        }
        return max;
    }
}
