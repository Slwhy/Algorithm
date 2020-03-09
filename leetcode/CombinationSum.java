package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2019/11/25
 * @description: num 39
 */
public class CombinationSum {
    //leetcode 上的解法
    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
            res.add(new ArrayList<>(pre));
            return;
        }
        // 优化添加的代码2：在循环的时候做判断，尽量避免系统栈的深度
        // residue - candidates[i] 表示下一轮的剩余，如果下一轮的剩余都小于 0 ，就没有必要进行后面的循环了
        // 这一点基于原始数组是排序数组的前提，因为如果计算后面的剩余，只会越来越小
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            pre.add(candidates[i]);
            // 【关键】因为元素可以重复使用，这里递归传递下去的是 i 而不是 i + 1
            findCombinationSum(residue - candidates[i], i, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //自己写的BFS,
        // 但是存在两个个问题,
        // 1是对于tmp变量如何管理，因为进入下一次递归的时候,会对tmp变量进行修改,但当递归结束时,又希望能够返回到原先的状态
        // 2是如何进行剪枝,避免重复情况的出现
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = candidates.length - 1; i >= 0; i--) {
            combinationSumCore(candidates, target, i, res, tmp);
            tmp.clear();
        }
        return res;
    }

    public static void combinationSumCore(int[] candidates, int remains, int index, List<List<Integer>> res, ArrayList<Integer> tmp) {
        if (remains == 0) {
            ArrayList item = new ArrayList(tmp);
            res.add(item);
        }
        if (index >= 0 && remains > 0) {
            if (remains >= candidates[index]) {
                int count = remains / candidates[index];
                for (int i = 0; i < count; i++) {
                    remains = remains - candidates[index];
                    tmp.add(candidates[index]);
                    combinationSumCore(candidates, remains, index - 1, res, new ArrayList<>(tmp));
                }
            } else combinationSumCore(candidates, remains, index - 1, res, new ArrayList<>(tmp));
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{2, 3, 5};
        System.out.println(combinationSum(array, 8));
    }
}
