package leetcode.random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2019/11/27
 * @description: num 40
 */
public class CombinationSum2 {

    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。
            // 这一步剪枝操作基于 candidates 数组是排序数组的前提下
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            // 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }

    public List<List<Integer>> combinationSum2_2(int[] candidates, int target) {
        // leetcode 上的解法，进行了剪枝，时间复杂度对于自己的来说优越了很多
        //https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 垃圾时间复杂度,先对 candidates 进行了排序,而后在添加每条正确路径的时候还要进行去重
        // 存在问题,当数组中存在重复数据,如何对路径进行去重
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        Stack stack1 = new Stack();
        combinationSum2Core(candidates, target, 0, stack1, res);
        return res;
    }

    public static void combinationSum2Core(int[] candidates, int target, int index, Stack stack1, List<List<Integer>> res) {
        if (target == 0) {
            ArrayList tmp = new ArrayList<Integer>(stack1);
            if (!res.contains(tmp)) {
                res.add(new ArrayList<Integer>(stack1));
            }
        }
        if (index < candidates.length && target > 0) {
            stack1.add(candidates[index]);
            combinationSum2Core(candidates, target - candidates[index], index + 1, stack1, res);
            stack1.pop();
            combinationSum2Core(candidates, target, index + 1, stack1, res);
        }
    }
}
