package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/29
 * @description: 50. Pow(x, n)
 */
public class MyPow {

    public double myPow(double x, int n) {
        /**
         * @Author slwhy
         * @Date 2020/4/29
         * @Param [x, n]
         * @return double
         * @Description
         **/
        if (n >= 0) return helper(x, n);
        else return 1 / helper(x, n);
    }

    public double helper(double x, int n) {
        if (n == 0) return 1;
        if (n % 2 == 0) return helper(x * x, n / 2);
        else return x * helper(x * x, n / 2);
    }

    public double myPow2(double x, int n) {
        /**
         * @Author slwhy
         * @Date 2020/4/29
         * @Param [x, n]
         * @return double
         * @Description 快速幂，leetcode上的解法
         **/
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    public double myPow1(double x, int n) {
        /**
         * @Author slwhy
         * @Date 2020/4/29
         * @Param [x, n]
         * @return double
         * @Description 暴力，会超时
         **/
        if (x == 1) return x;
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        for (int i = 0; i > n; i--) {
            res = res * x;
        }
        return n > 0 ? res : 1 / res;
    }
}
