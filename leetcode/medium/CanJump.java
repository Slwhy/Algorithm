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
        /**
         * @Author slwhy
         * @Date 2020/4/16
         * @Param [nums]
         * @return boolean
         * @Description leetcode上的，对方法2进行了精简
         **/
        if (nums.length < 2) return true;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (index < i) return false;
            index = Math.max(index, i + nums[i]);
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/4/16
         * @Param [nums]
         * @return boolean
         * @Description 自己想出来了的, 挨个进行跳
         **/
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        int index = 1;
        for (int i = 0; i < nums.length && can[i]; i++) {
            if (i + nums[i] >= nums.length - 1) return true;
            while (index <= i + nums[i]) can[index++] = true;
        }
        return can[can.length - 1];

    }

    public boolean canJump1(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/4/16
         * @Param [nums]
         * @return boolean
         * @Description DFS思路
         **/
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

    public static void main(String[] args) {
        CanJump canJump = new CanJump();
        canJump.canJump2(new int[]{3,2,1,0,4});
    }

}
