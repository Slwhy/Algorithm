package leetcode;

/**
 * @author: slwhy
 * @date: 2019/10/18
 * @description: num 7
 */
public class Reverse {
    public static int reverse2(int x) {
        // Leetcode 上的解法
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;

    }

    public static int reverse(int x) {
        //这个解法作弊了，因为题目要求计算机只能存下 32 位的数据
//        int num;
//        if (x < 0) num = -x;
//        else num = x;
        boolean isPositive = true;
        if (x < 0) {
            x = -x;
            isPositive = false;
        }
        long res = 0;
        while (x >= 1) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (isPositive) {
            return res > Integer.MAX_VALUE ? 0 : (int) res;
        } else {
            res = -res;
            return res < Integer.MIN_VALUE ? 0 : (int) res;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
