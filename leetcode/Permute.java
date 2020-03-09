package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2019/11/24
 * @description: num 46
 */
public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        //BFS
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 1) return res;
        permuteCore(nums, 0, res);
        return res;
    }

    public void permuteCore(int[] nums, int n, List<List<Integer>> res) {
        if (n == nums.length) {
            ArrayList tmp = new ArrayList();
            for (int j = 0; j < nums.length; j++) {
                tmp.add(nums[j]);
            }
            res.add(tmp);
        }
        for (int i = n; i < nums.length; i++) {
            swap(nums, n, i);
            permuteCore(nums, n + 1, res);
            swap(nums, n, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int [] array = new int[]{1,3,2};
        Permute test = new Permute();
        System.out.println(test.permute(array));
    }
}
