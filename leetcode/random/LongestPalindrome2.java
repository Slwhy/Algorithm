package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/3/19
 * @description: 409. 最长回文串
 */
public class LongestPalindrome2 {
    public int longestPalindrome(String s) {
        int max = 0;
        boolean odds = false;
        char[] chars = s.toCharArray();
        char[] count = new char[52];
        for (char c : chars) {
            if (c < 'Z') count[c - 'A' + 26] += 1;
            else count[c - 'a'] += 1;
        }
        for (int i = 0; i < count.length; i++) {
            max = max + (count[i] / 2) * 2;
            if (!odds && count[i] % 2 == 1) odds = true;
        }
        if (odds) return max + 1;
        else return max;
    }
}
