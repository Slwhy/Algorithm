package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/10/24
 * @description: num 12
 */
public class IntToRoman {

    public static String intToRoman3(int num) {
        //leetcode上推导每一位上的数值的解法
        String[] Q = new String[]{"", "M", "MM", "MMM"};
        String[] B = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] S = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] G = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return Q[num / 1000] + B[(num % 1000) / 100] + S[(num % 100) / 10] + G[num % 10];
    }

    public static String intToRoman2(int num) {
        // 对方法1进行了优化,用循环简化了代码
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (num >= nums[i]) {
                    num = num - nums[i];
                    res.append(romans[i]);
                    break;
                }
            }
        }
        return res.toString();
    }

    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        while (num > 0) {
            if (num >= 1000) {
                res.append("M");
                num = num - 1000;
            } else if (num >= 900) {
                num = num - 900;
                res.append("CM");
            } else if (num >= 500) {
                num = num - 500;
                res.append("D");
            } else if (num >= 400) {
                num = num - 400;
                res.append("CD");
            } else if (num >= 100) {
                num = num - 100;
                res.append("C");
            } else if (num >= 90) {
                num = num - 90;
                res.append("XC");
            } else if (num >= 50) {
                num = num - 50;
                res.append("L");
            } else if (num >= 40) {
                num = num - 40;
                res.append("XL");
            } else if (num >= 10) {
                num = num - 10;
                res.append("X");
            } else if (num >= 9) {
                num = num - 9;
                res.append("IX");
            } else if (num >= 5) {
                num = num - 5;
                res.append("V");
            } else if (num >= 4) {
                num = num - 4;
                res.append("IV");
            } else {
                num = num - 1;
                res.append("I");
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1927));
        System.out.println(intToRoman3(1927));

    }
}
