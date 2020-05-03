package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/30
 * @description: 29. 两数相除
 */
public class Divide {
    public int divide(int dividend, int divisor) {
        boolean isNegative = (dividend > 0) ^ (divisor > 0);
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        int res = 0;
        while (dividend <= divisor) {
            int tmpRes = -1;
            int tmpDivisor = divisor;
            while (dividend <= (tmpDivisor << 1)) {
                if (tmpDivisor <= (Integer.MIN_VALUE >> 1)) break;
                tmpRes = tmpRes << 1;
                tmpDivisor = tmpDivisor << 1;
            }
            res += tmpRes;
            dividend -= tmpDivisor;
        }
        if (isNegative) {
            return res;
        } else {
            if (res==Integer.MIN_VALUE) return Integer.MAX_VALUE;
            else return -res;
        }
    }
}
