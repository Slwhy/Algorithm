package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/2
 * @description: 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
 */
public class LeftRotateString {
    public static String LeftRotateString(String str, int n) {
        /**
        * @Author slwhy
        * @Date 2019/9/3
        * @Param [str, n]
        * @return java.lang.String
        * @Description
         * 牛客有种很巧妙的优化方案，
         * https://www.nowcoder.com/profile/1687517/codeBookDetail?submissionId=19867252
         * str += str;
         * return str.substr(n, len);
        **/
        int len = str.length();
        if (len < 1) {
            return "";
        }
        int num = n % len;
        String left = str.substring(0, num);
        String right = str.substring(num);
        return right + left;

    }

}
