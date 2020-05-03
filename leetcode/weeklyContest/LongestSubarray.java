package leetcode.weeklyContest;

/**
 * @author: slwhy
 * @date: 2020/5/3
 * @description: 5402. 绝对差不超过限制的最长连续子数组
 */
public class LongestSubarray {

    public int longestSubarray(int[] nums, int limit) {
        int start = 0;
        int longest = 0;
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i] - max) <= limit && Math.abs(nums[i] - min) <= limit) {
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i]);
            } else {
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for (int j = i; j >= start; j--) {
                    if (Math.abs(nums[i] - nums[j]) <= limit) {
                        max = Math.max(max, nums[j]);
                        min = Math.min(min, nums[j]);
                    } else {
                        start = j + 1;
                        break;
                    }
                }
            }
            longest = Math.max(longest, (i - start + 1));
        }
        return longest;
    }


    public int longestSubarray2(int[] nums, int limit) {
        int start = 0;
        int longest = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = start; j <= i; j++) {
                if (Math.abs(nums[i] - nums[j]) > limit) {
                    start = j + 1;
                }
            }
            longest = Math.max(longest, (i - start + 1));
        }
        return longest;
    }

    public static void main(String[] args) {
        LongestSubarray longestSubarray = new LongestSubarray();
        System.out.println(longestSubarray.longestSubarray(new int[]{7, 40, 10, 10, 40, 39, 96, 21, 54, 73, 33, 17, 2, 72, 5, 76, 28, 73, 59, 22, 100, 91, 80, 66, 5, 49, 26, 45, 13, 27, 74, 87, 56, 76, 25, 64, 14, 86, 50, 38, 65, 64, 3, 42, 79, 52, 37, 3, 21, 26, 42, 73, 18, 44, 55, 28, 35, 87}, 63));
    }


}
