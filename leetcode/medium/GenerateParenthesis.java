package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/4/2
 * @description: 22. 括号生成
 */
public class GenerateParenthesis {
    public ArrayList<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        /**
         * @Author slwhy
         * @Date 2020/4/2
         * @Param [n]
         * @return java.util.List<java.lang.String>
         * @Description dp思路，leetcode的解法
         **/
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }


    public List<String> generateParenthesis1(int n) {
        /**
         * @Author slwhy
         * @Date 2020/4/2
         * @Param [n]
         * @return java.util.List<java.lang.String>
         * @Description BFS的思路，和 电话号码的字母组合 这道题基本类似
         **/
        helper("", n, n);
        return res;
    }

    public void helper(String tmp, int left, int right) {
        if (left >= 0 && right >= 0) {
            if (left == 0 && right == 0) {
                res.add(tmp);
            }
            helper(tmp + "(", left - 1, right);
            if (left < right) {
                helper(tmp + ")", left, right - 1);
            }
        }
    }
}
