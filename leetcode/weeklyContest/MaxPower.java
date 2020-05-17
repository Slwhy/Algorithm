package leetcode.weeklyContest;

/**
 * @author: slwhy
 * @date: 2020/5/16
 * @description: 5396. 连续字符
 */
public class MaxPower {
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int max = 0;
        int count = 0;
        char curr = '0';
        for (int i = 0; i < chars.length; ) {
            if (count == 0) curr = chars[i];
            if (curr == chars[i]) {
                count++;
                i++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }
        return Math.max(count, max);
    }

    public static void main(String[] args) {
        MaxPower maxPower = new MaxPower();
        System.out.println(maxPower.maxPower("j"));
    }
}
