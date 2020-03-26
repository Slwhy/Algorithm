package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/3/25
 * @description: 5. 最长回文子串
 */
public class LongestPalindrome {
    public String res = "";

    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            longestPalindromeCore(s, i, i + 1);
            longestPalindromeCore(s, i - 1, i + 1);
        }

        return res;
    }

    public void longestPalindromeCore(String s, int left, int right) {
        if (left >= 0 && right < s.length() && left < right && s.charAt(left) == s.charAt(right)) {
            longestPalindromeCore(s, left - 1, right + 1);
            if (res.length() < right - left + 1) {
                res = s.substring(left, right + 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("abcde".substring(0, 1));
    }
}
