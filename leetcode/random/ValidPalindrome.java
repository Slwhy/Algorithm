package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/5/19
 * @description: 680. 验证回文字符串 Ⅱ
 */
public class ValidPalindrome {

    int l;
    int r;

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        if (helper(left, right, s)) return true;
        left = l;
        right = r;
        return helper(left + 1, right, s) || helper(left, right - 1, s);
    }

    public boolean helper(int left, int right, String s) {
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else break;
        }
        l = left;
        r = right;
        if (left >= right) return true;
        else return false;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.validPalindrome("abc"));
    }

}
