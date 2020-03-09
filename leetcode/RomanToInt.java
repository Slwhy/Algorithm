package leetcode;

/**
 * @author: slwhy
 * @date: 2019/10/25
 * @description: num 13
 */
public class RomanToInt {

    public static int romanToInt2(String s) {
        //对方法1进行优化,减少了循环次数,因为内循环是从大到小的,不必每次都从0开始循环
        int res = 0;
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            while (j < romans.length) {
                if ((i + romans[j].length() <= s.length()) && s.substring(i, i + romans[j].length()).equals(romans[j])) {
                    res = res + nums[j];
                    i = i + romans[j].length() - 1;
                    break;
                } else j++;
            }
        }
        return res;
    }

    public static int romanToInt(String s) {
        int res = 0;
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < romans.length; j++) {
                if ((i + romans[j].length() <= s.length()) && s.substring(i, i + romans[j].length()).equals(romans[j])) {
                    res = res + nums[j];
                    if (romans[j].length() == 2) i++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt2("MMCDIV"));
//        System.out.println("123".substring(2, 3));
    }
}
