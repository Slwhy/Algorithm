package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/19
 * @description: 70. 爬楼梯
 */
public class ClimbStairs {

    public int climbStairs1(int n) {
        /**
         * @Author slwhy
         * @Date 2020/3/19
         * @Param [n]
         * @return int
         * @Description 迭代法
         **/
        if (n < 3) return n;
        int res = 0;
        int last = 2;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            res = last + second;
            second = last;
            last = res;
        }
        return res;
    }

    public int climbStairs(int n) {
        /**
         * @Author slwhy
         * @Date 2020/3/19
         * @Param [n]
         * @return int
         * @Description 直接递归思路明确, leetcode 会超时
         **/
        if (n <= 2) return n;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
