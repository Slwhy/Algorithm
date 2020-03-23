package leetcode.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2019/10/29
 * @description: num 22
 */
public class GenerateParenthesis {
    public static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        //通过两个变量统计已经放进去的左右括号个数，当放进去的左括号个数多于右括号时，才是合法的
        generateParenthesisCore(n, n, "");
        return res;
    }

    public static void generateParenthesisCore(int left, int right, String tmp) {
        if (left <= right && left >= 0 && right >= 0) {
            if (left == 0 && right == 0) res.add(tmp);
            generateParenthesisCore(left - 1, right, tmp + "(");
            generateParenthesisCore(left, right - 1, tmp + ")");
        }
    }

    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
