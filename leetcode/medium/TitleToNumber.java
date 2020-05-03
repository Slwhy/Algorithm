package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/28
 * @description: 171. Excel表列序号
 */
public class TitleToNumber {

    public int titleToNumber(String s) {
        /**
         * @Author slwhy
         * @Date 2020/4/28
         * @Param [s]
         * @return int
         * @Description leetcode 上的写法，思路一样，耗时减少
         **/
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public int titleToNumber1(String s) {
        /**
         * @Author slwhy
         * @Date 2020/4/28
         * @Param [s]
         * @return int
         * @Description 类似于进制转换
         **/
        int lent = s.length();
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 1; i <= lent; i++) {
            res += (int) Math.pow(26, i - 1) * (chars[lent - i] - 'A' + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println('B' - 'A');
    }
}
