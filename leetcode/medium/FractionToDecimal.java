package leetcode.medium;

import java.util.HashMap;

/**
 * @author: slwhy
 * @date: 2020/5/2
 * @description: 166. 分数到小数
 */
public class FractionToDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        /**
         * @Author slwhy
         * @Date 2020/5/2
         * @Param [numerator, denominator]
         * @return java.lang.String
         * @Description 思路，如果出现相同的余数，那么余数后面的部分应该为循环节
         * 该方法和下面的 fractionToDecimal1是一样的，只不过是对其代码进行了整理
         **/
        if (numerator == 0) return "0";
        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        long numeratorLong = numerator;
        long denominatorLong = denominator;
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long quotient;
        if ((numerator > 0) ^ (denominator > 0)) res.append("-");
        while (numeratorLong != 0) {
            quotient = numeratorLong / denominatorLong;
            numeratorLong = numeratorLong % denominatorLong;
            if (map.containsKey(numeratorLong)) {
                res.append(quotient);
                res.insert(map.get(numeratorLong), "(");
                res.append(")");
                break;
            } else {
                if (res.length() == 1 || res.length() == 0) {
                    res.append(quotient);
                    res.append(".");
                } else res.append(quotient);
                map.put(numeratorLong, res.length());
            }
            numeratorLong = numeratorLong * 10;
        }
        if (res.charAt(res.length() - 1) == '.') res.delete(res.length() - 1, res.length());
        return res.toString();
    }

    public String fractionToDecimal1(int numerator, int denominator) {
        if (numerator == 0) return "0";
        HashMap<Long, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        int quotient;
        String s;
        boolean isLoop = false;
        boolean isNegative = (numerator > 0) ^ (denominator > 0);
        long numeratorLong = numerator;
        while (numeratorLong != 0) {
            quotient = (int) (numeratorLong / denominator);
            numeratorLong = numeratorLong % denominator;
            s = Integer.toString(quotient);
            if (quotient < 0) s = s.substring(1, s.length());
            if (map.containsKey(numeratorLong)) {
                isLoop = true;
                res.append(s);
                break;
            }
            if (res.length() == 0) {
                if (isNegative) res.append("-");
                res.append(s);
                res.append(".");
            } else {
                res.append(s);
            }
            map.put(numeratorLong, res.length());
            numeratorLong = numeratorLong * 10;
        }
        if (isLoop) {
            res.insert(map.get(numeratorLong), "(");
            res.append(")");
        }
        if (res.charAt(res.length() - 1) == '.') res.delete(res.length() - 1, res.length());
        return res.toString();

    }

    public static void main(String[] args) {
        FractionToDecimal fractionToDecimal = new FractionToDecimal();
        System.out.println(fractionToDecimal.fractionToDecimal(2, 1));
        System.out.println(Integer.MIN_VALUE);
    }
}
