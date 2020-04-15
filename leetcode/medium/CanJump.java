package leetcode.medium;

import java.util.HashSet;

/**
 * @author: slwhy
 * @date: 2020/4/15
 * @description: 55. 跳跃游戏
 */
public class CanJump {
    boolean res = false;
    HashSet<Integer> index = new HashSet<>();

    public boolean canJump(int[] nums) {
        dfs(nums, nums.length - 1, nums.length - 1);
        return res;
    }

    public void dfs(int[] nums, int start, int end) {
        if (start >= 0 && end < nums.length && !res) {
            index.add(start);
            if (start == 0) {
                res = true;
            }
            for (int i = start - 1; i >= 0; i--) {
                if (i + nums[i] >= start && !index.contains(i)) dfs(nums, i, end);
            }
        }
    }

}
