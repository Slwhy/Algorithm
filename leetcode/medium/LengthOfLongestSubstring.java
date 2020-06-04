package leetcode.medium;

import leetcode.random.MaxAreaOfIsland;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author: slwhy
 * @date: 2020/3/25
 * @description: 3. 无重复字符的最长子串
 */
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        /**
         * @Author slwhy
         * @Date 2020/6/3
         * @Param [s]
         * @return int
         * @Description dp解
         **/
        if (s.length() < 2) return s.length();
        char[] chars = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            int j = i - 1;
            for (; i - j <= dp[i - 1]; j--) {
                if (chars[i] == chars[j]) break;
            }
            if (i - j > dp[i - 1]) dp[i] = dp[i - 1] + 1;
            else dp[i] = i - j;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        /**
         * @Author slwhy
         * @Date 2020/3/25
         * @Param [s]
         * @return int
         * @Description leetcode 上的,滑动窗口,针对方法1的优化,可以将方法1的队列优化了
         **/
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }


    public int lengthOfLongestSubstring1(String s) {
        if (s.length() < 2) return s.length();
        char[] chars = s.toCharArray();
        int max = 0;
        Set<Character> curr = new HashSet<Character>();
        Queue<Character> queue = new LinkedList<Character>();
        for (int i = 0; i < chars.length; i++) {
            if (curr.contains(chars[i])) {
                while (!queue.isEmpty()) {
                    Character tmp = queue.poll();
                    curr.remove(tmp);
                    if (tmp.equals(chars[i])) break;
                }
                curr.add(chars[i]);
                queue.add(chars[i]);
            } else {
                curr.add(chars[i]);
                queue.add(chars[i]);
            }
            max = Math.max(queue.size(), max);
        }
        return max;
    }
}
