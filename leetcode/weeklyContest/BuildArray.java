package leetcode.weeklyContest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/5/10
 * @description: 5404. 用栈操作构建数组
 */
public class BuildArray {
    public List<String> buildArray(int[] target, int n) {
        int index = 0;
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (index == target.length) return res;
            res.add("Push");
            if (target[index] == i) index++;
            else res.add("Pop");
        }
        return res;
    }
}
