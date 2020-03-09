package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/8
 * @description: 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是
 */
public class IsNumeric {
    public static boolean isNumeric(char[] str) {
        /**
         * @Author slwhy
         * @Date 2019/9/8
         * @Param [str]
         * @return boolean
         * @Description
         * 比较需要注意的case
         * 12e+4.3不是数
         * 12e+5 是数
         * 故e后面不能存在小数点
         **/
        //boolean res = true;
        boolean decimal = false; //小数标记位，true表示检测到了小数点
        boolean e = false; // 指数标记位，true 表示检测到了e
        for (int i = 0; i < str.length; i++) {
            if (i == 0) {
                if (str[0] == '+' || str[0] == '-' || (47 < str[0] && str[0] < 58) || str[0] == 'e' || str[0] == 'E') {
                    continue;
                }
                return false;
            }
            if (47 < str[i] && str[i] < 58) {
                continue;
            }
            if (e == false && decimal == false && str[i] == '.' && i < str.length - 1) {
                if (47 < str[i + 1] && str[i + 1] < 58) {
                    decimal = true;
                    continue;
                }
            }
            if (e == false && (str[i] == 'e' || str[i] == 'E') && i < str.length - 1) {
                if ((47 < str[i + 1] && str[i + 1] < 58) || str[i + 1] == '-' || str[i + 1] == '+') {
                    if (str[i + 1] == '-' || str[i + 1] == '+') {
                        i++;
                    }
                    e = true;
                    continue;
                }
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isNumeric("12e+5".toCharArray()));
    }
}
