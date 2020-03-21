package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 326. 3的幂
 */
public class IsPowerOfThree {

    public boolean isPowerOfThree(int n) {
        /**
         * @Author slwhy
         * @Date 2020/3/21
         * @Param [n]
         * @return boolean
         * @Description leetcode 上的解法
         * 假设 n = Math.pow(3,i),如果能求得 i为整数,则说明符合条件
         **/
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public boolean isPowerOfThree2(int n) {
        /**
         * @Author slwhy
         * @Date 2020/3/21
         * @Param [n]
         * @return boolean
         * @Description leetcode 上的整数限制法,
         * n是一个int变量,所以n<=Integer.MIN_VALUE
         * 所以最大的3的幂次方是 Math.pow(3,19),其他所有符合条件的数为 Math.pow(3,0) ...Math.pow(3,19)
         * 且3是质数,所以 Math.pow(3,19) 的除数只有 Math.pow(3,0),Math.pow(3,1)...Math.pow(3,19)等
         **/
        return n > 0 && 1162261467 % n == 0;

    }

    public boolean isPowerOfThree1(int n) {
        while (n >= 3) {
            if (n % 3 != 0) return false;
            n = n / 3;
        }
        if (n == 1) return true;
        else return false;
    }
}
