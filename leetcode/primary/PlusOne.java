package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/8
 * @description: 加一
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        /**
         * @Author slwhy
         * @Date 2020/3/8
         * @Param [digits]
         * @return int[]
         * @Description
         **/
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    public int[] plusOne1(int[] digits) {
        if (digits.length < 1) return digits;
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        if (digits[digits.length - 1] == 10) {
            int tmp = 1;
            digits[digits.length - 1] = 0;
            for (int i = digits.length - 2; i >= 0; i--) {
                digits[i] = digits[i] + tmp;
                if (digits[i] == 10) {
                    tmp = 1;
                    digits[i] = 0;
                } else tmp = 0;
            }
            if (tmp == 1) {
                int[] res = new int[digits.length + 1];
                res[0] = 1;
                for (int j = 0; j < digits.length; j++) {
                    res[j + 1] = digits[j];
                }
                return res;
            } else return digits;
        } else return digits;
    }
}
