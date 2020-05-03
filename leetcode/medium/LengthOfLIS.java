package leetcode.medium;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/4/20
 * @description: Longest Increasing Subsequence
 */
public class LengthOfLIS {

    int res = 1;

    public int lengthOfLIS(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/4/26
         * @Param [nums]
         * @return int
         * @Description leetcode上的解法, 动态规划
         **/
        if (nums.length < 2) return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public void helper(int[] nums, int index, int last, int count) {
        /**
         * @Author slwhy
         * @Date 2020/4/26
         * @Param [nums, index, last, count]
         * @return void
         * @Description 暴力
         **/
        if (index == nums.length) res = Math.max(res, count);
        else {
            if (nums[index] > last) {
                helper(nums, index + 1, last, count);
                helper(nums, index + 1, nums[index], count + 1);
            } else helper(nums, index + 1, last, count);
        }
    }


    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

}
