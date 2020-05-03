package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/29
 * @description: 69. x 的平方根
 */
public class MySqrt {

    int num;

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        num = x;
        return (int) sqrt(x);
    }

    public double sqrt(double x) {
        /**
         * @Author slwhy
         * @Date 2020/4/29
         * @Param [x]
         * @return double
         * @Description 牛顿法，用切线来逼近方程 x^2-a=0 的根
         * 参考 https://leetcode-cn.com/problems/sqrtx/solution/niu-dun-die-dai-fa-by-loafer/
         **/
        double res = (x + num / x) / 2;
        if (res == x) return res;
        else return sqrt(res);
    }

    public int mySqrt1(int x) {
        return (int) helper(x, 0, x);
    }

    public double helper(int x, int left, int right) {
        /**
         * @Author slwhy
         * @Date 2020/4/29
         * @Param [x, left, right]
         * @return double
         * @Description 二分法, 但是要注意当right很大时,如果mid未int类型,mid*mid 很可能会溢出
         **/
        if (left < right) {
            int tmp = left + (right - left) / 2;
            double mid = tmp;
            if (mid * mid == x) return mid;
            else if (mid * mid > x) return helper(x, left, tmp - 1);
            else if ((mid + 1) * (mid + 1) > x) return mid;
            return helper(x, tmp + 1, right);
        } else return left;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(1));
    }
}
