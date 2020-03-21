package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 13. 罗马数字转整数
 */
public class RomanToInt {
    public int romanToInt(String s) {
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
}
