package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/10
 * @description: 反转字符串
 */
public class ReverseString {
    public void reverseString(char[] s) {
        /**
         * @Author slwhy
         * @Date 2020/3/10
         * @Param [s]
         * @return void
         * @Description 双指针解法
         **/
        int left = 0;
        int right = s.length - 1;
        char tmp;
        while (left < right) {
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}
