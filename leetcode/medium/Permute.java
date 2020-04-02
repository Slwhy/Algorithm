package leetcode.medium;

import java.util.*;

/**
 * @author: slwhy
 * @date: 2020/4/2
 * @description: 46. 全排列
 */
public class Permute {
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> remains = new HashSet<Integer>();
        for (int i : nums) {
            remains.add(i);
        }
        helper(new ArrayList<Integer>(), remains);
        return res;
    }

    public void helper(ArrayList<Integer> tmp, Set<Integer> remains) {
        /**
         * @Author slwhy
         * @Date 2020/4/2
         * @Param [tmp, remains]
         * @return void
         * @Description DFS
         **/
        if (remains.isEmpty()) {
            res.add(tmp);
        } else {
            for (Integer i : remains) {
                ArrayList list = new ArrayList(tmp);
                HashSet set = new HashSet(remains);
                list.add(i);
                set.remove(i);
                helper(list, set);
            }
        }
    }

    public void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {

    }
}
