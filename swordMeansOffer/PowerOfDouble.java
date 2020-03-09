package swordMeansOffer;

/**
 * @author: slwhy
 * @description: double的整数次方
 * @date: 2019/5/2
 */
public class PowerOfDouble {
    public static double Power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    public static double Power1(double base, int exponent) {
        /**
         * @description 利用循环手动实现次方运算
         * @author slwhy
         * @date 2019/5/2
         * @param base
         * @param exponent
         * @return double
         */
        if (base == 0 || base == 1) {
            return base;
        }
        if (exponent == 0) {
            return 1.0;
        }
        int n = Math.abs(exponent);
        double res = 1;
        for (int i = 0; i < n; i++) {
            res = res * base;
        }
        if (exponent > 0) {
            return res;
        } else {
            return 1 / res;
        }

    }

    public static double Power2(double base, int exponent) {
        /**
         * @description 用递归实现
         * @author slwhy
         * @date 2019/5/2
         * @param base
         * @param exponent
         * @return double
         */
        if (base == 0 || base == 1) {
            return base;
        }
        if (exponent == 0) {
            return 1.0;
        }
        if (exponent>0){
            return base*Power2(base,exponent-1);
        }else {
            return 1/base*Power2(base,exponent+1);
        }
    }
        public static void main(String[] args) {
        System.out.println(Power(1.0, -3) == Power2(1.0, -3));

    }
}
