package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/5/2
 * @description: 371. 两整数之和
 */
public class GetSum {
    public int getSum(int a, int b) {
        /**
         * @Author slwhy
         * @Date 2020/5/8
         * @Param [a, b]
         * @return int
         * @Description 或运算可以得到不带进位的加法结果，与运算得到进位结果;这个两个结果又可以看作两个数相加
         **/

        int tmp;
        while (b != 0) {
            tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }

        return a;
    }

    public static void main(String[] args) {

    }
}
