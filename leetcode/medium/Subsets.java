package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/4/2
 * @description: 78. 子集
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/4/3
         * @Param [nums]
         * @return java.util.List<java.util.List < java.lang.Integer>>
         * @Description leetcode 上的解法,基于位运算
         **/
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;

    }

    public List<List<Integer>> subsets1(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/4/3
         * @Param [nums]
         * @return java.util.List<java.util.List < java.lang.Integer>>
         * @Description dfs解法, 自己像出来的
         **/
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, 0, path);
        return res;
    }

    public void dfs(int[] nums, int depth, ArrayList<Integer> path) {
        if (depth == nums.length) {
            res.add(new ArrayList<>(path));
        } else {
            path.add(nums[depth]);
            dfs(nums, depth + 1, path);
            path.remove(path.size() - 1);
            dfs(nums, depth + 1, path);
        }

    }

}
