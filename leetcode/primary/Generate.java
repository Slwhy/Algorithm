package leetcode.primary;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 118. 杨辉三角
 */
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new LinkedList<>();
            tmp.add(1);
            for (int j = 1; j < i; j++) {
                tmp.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            if (i > 0) tmp.add(1);
            res.add(tmp);
        }
        return res;
    }
}
