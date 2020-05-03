package leetcode.weeklyContest;

/**
 * @author: slwhy
 * @date: 2020/4/26
 * @description: 5392. 分割字符串的最大得分
 */
public class MaxScore {
    public int maxScore(String s) {
        char[] chars = s.toCharArray();
        int num0;
        int num1;
        int max = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            num0 = 0;
            num1 = 0;
            for (int j = 0; j <= i; j++) {
                if (chars[j] == '0') num0++;
            }
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] == '1') num1++;
            }
            max = Math.max(max, num0 + num1);
        }
        return max;
    }
}
