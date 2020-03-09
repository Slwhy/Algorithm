package leetcode;

/**
 * @author: slwhy
 * @date: 2019/11/19
 * @description: num 29
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        //没想出来，leetcode上的解法
//        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        int res = 0;
        while (dividend <= divisor) {
            int tmpRes = -1;
            int tmpDivi = divisor;
            while (dividend <= (tmpDivi << 1)) {
                if (tmpDivi <= (Integer.MIN_VALUE >> 1)) break;
                tmpRes = tmpRes << 1;
                tmpDivi = tmpDivi << 1;
            }
            res = res + tmpRes;
            dividend = dividend - tmpDivi;
        }
        if (isNegative) {
            return res;
        } else {
            if (res==Integer.MIN_VALUE) return Integer.MAX_VALUE;
            else return -res;
        }
    }

    public static void main(String[] args) {
        System.out.println(-Integer.MIN_VALUE<Integer.MIN_VALUE);
    }
}
