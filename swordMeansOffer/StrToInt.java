package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/5
 * @description: 将一个字符串转换成一个整数(实现Integer.valueOf ( string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * <p>
 * input:
 * +2147483647
 * 1a33
 * <p>
 * output:
 * 2147483647
 * 0
 */
public class StrToInt {
    public static int StrToInt(String str) {
        /**
         * @Author slwhy
         * @Date 2019/9/5
         * @Param [str]
         * @return int
         * @Description
         * 将string 转为charArray 而后对每个字符进行解析
         * 注意string最左边为符号或者是最高位
         **/
        char[] num = str.toCharArray();
        int res = 0;
        int tab = 1; //标记正负
        int count = 1; //统计*10的次数
        for (int i = num.length - 1; i >= 0; i--) {
            if (i == 0) {
                if (num[0] == '+') {
                    continue;
                }
                if (num[0] == '-') {
                    tab = -1;
                    continue;
                }
                if ((47 < num[0] && num[0] < 58)) {
                    res = res + (num[0] - '0') * count;
                    continue;
                }
                return 0;
            } else {
                if (num[i] < 48 || num[i] > 57) {
                    return 0;
                }
                res = res + (num[i] - '0') * count;
            }
            count = count * 10;

        }
        return res * tab;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("+2147483647"));
        System.out.println(StrToInt("+2147483647"));
    }
}
