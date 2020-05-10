package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/5/8
 * @description: 221. 最大正方形
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        /**
         * @Author slwhy
         * @Date 2020/5/8
         * @Param [matrix]
         * @return int
         * @Description 参考leetcode上的，dp解法
         **/
        if (matrix.length < 1) return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maxEdge = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i + 1][j], dp[i][j]), dp[i][j + 1]) + 1;
                    maxEdge = Math.max(maxEdge, dp[i + 1][j + 1]);
                }
            }
        }
        return maxEdge * maxEdge;
    }

    public int maximalSquare1(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, helper(matrix, i, j));
                }
            }
        }
        return max;
    }

    public int helper(char[][] matrix, int row, int column) {
        int step = 1;
        for (; row + step < matrix.length && column + step < matrix[0].length; step++) {
            for (int i = 0; i <= step; i++) {
                if (matrix[row + i][column + step] != '1' || matrix[row + step][column + i] != '1')
                    return step * step;
            }
        }
        return step * step;
    }

    public static void main(String[] args) {
        MaximalSquare maximalSquare = new MaximalSquare();
        System.out.println(maximalSquare.maximalSquare(new char[][]{{'1'}}));
    }
}
