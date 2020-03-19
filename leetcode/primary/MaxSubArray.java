package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/19
 * @description: 53. 最大子序和
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/19
         * @Param [nums]
         * @return int
         * @Description 优化了dp数组
         **/
        if (nums.length < 2) return nums[0];
        int max = nums[0];
        int curr;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(last + nums[i], nums[i]);
            max = Math.max(max, curr);
            last = curr;
        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/19
         * @Param [nums]
         * @return int
         * @Description dp[i] 表示以num[i]结尾的最大和子序列
         **/
        if (nums.length < 2) return nums[0];
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
