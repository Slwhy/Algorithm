package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/3/24
 * @description: 面试题 17.16. 按摩师
 */
public class Massage {
    public int massage(int[] nums) {
        if (nums.length < 1) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int max = 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
