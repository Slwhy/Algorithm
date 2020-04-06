package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/6
 * @description: 72. 编辑距离
 */
public class MinDistance {

    public int minDistance1(String word1, String word2) {
        /**
         * @Author slwhy
         * @Date 2020/4/6
         * @Param [word1, word2]
         * @return int
         * @Description dp解法
         **/
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int dis1 = dp[i - 1][j] + 1;
                int dis2 = dp[i][j - 1] + 1;
                int dis3 = word1.charAt(i - 1) == word2.charAt(j - 1) ? dp[i - 1][j - 1] : dp[i - 1][j - 1] + 1;
                dp[i][j] = Math.min(Math.min(dis1, dis2), dis3);
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public int minDistance(String word1, String word2) {
        /**
         * @Author slwhy
         * @Date 2020/4/6
         * @Param [word1, word2]
         * @return int
         * @Description 比较简单的递归解法, leetcode上会超时
         **/
        if (word1.length() < 1) return word2.length();
        if (word2.length() < 1) return word1.length();
        int dis1 = minDistance(word1, word2.substring(0, word2.length() - 1)) + 1;
        int dis2 = minDistance(word1.substring(0, word1.length() - 1), word2) + 1;
        int dis3 = minDistance(word1.substring(0, word1.length() - 1), word2.substring(0, word2.length() - 1));
        dis3 = word1.charAt(word1.length() - 1) == word2.charAt(word2.length() - 1) ? dis3 : dis3 + 1;
        return Math.min(Math.min(dis1, dis2), dis3);
    }

    public static void main(String[] args) {
        System.out.println("abcd".substring(0, "abcd".length()));
    }
}
