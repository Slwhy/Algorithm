package leetcode;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/14
 * @description: 300. 最长上升子序列
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/16
         * @Param [nums]
         * @return int
         * @Description leetcode上的，自己不会
         **/
        if (nums.length < 1) return 0;
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
//                max = Math.max(dp[i], max);
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }

    public int lengthOfLIS1(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/14
         * @Param [nums]
         * @return int
         * @Description leetcode 上的代码
         **/
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        LengthOfLIS test = new LengthOfLIS();
        int[] array = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        test.lengthOfLIS(array);
    }

}
