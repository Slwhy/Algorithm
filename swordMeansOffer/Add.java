package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/5
 * @description: 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {

    public static int Add(int num1, int num2) {

        /**
         * @Author slwhy
         * @Date 2019/9/5
         * @Param [num1, num2]
         * @return int
         * @Description
         * 第一反应想到了要利用位运算，但没有想到如何具体实现
         * 参考牛客：https://www.nowcoder.com/profile/175539/codeBookDetail?submissionId=1501956
         * 两个数异或，得到的是对应的位相加的值（不考虑进位的情况）
         * 两个数相与，而后左移一位得到的是两个数相加将会产生的进位
         * 结果应该是上面两个值的和，但是这两个的和有可能会产生进位，所以要重复前面两步骤，直到进位为0
         **/

        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

}
