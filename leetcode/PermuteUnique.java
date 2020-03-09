package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: slwhy
 * @date: 2019/11/27
 * @description: num 47
 */
public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        if (nums.length < 1) return res;
        permuteUniqueCore(nums, 0, res);
        return res;
    }

    public void permuteUniqueCore(int[] nums, int index, List<List<Integer>> res) {
        // 自己参考39，40题想的回溯剪枝，但是不知道为啥就是有一部分重复的没有被剪干净
        if (index == nums.length) {
            List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
            res.add(list);
//            if (!res.contains(list)) res.add(list);
        }
        for (int i = index; i < nums.length; i++) {
//            if (i > index && nums[i] == nums[i - 1]) continue;
            if (i > index && nums[i] == nums[index]) continue;
            swap(nums, index, i);
            permuteUniqueCore(nums, index + 1, res);
            swap(nums, index, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,0,9};
        PermuteUnique test = new PermuteUnique();
        System.out.println(test.permuteUnique(array).size());

    }
}
