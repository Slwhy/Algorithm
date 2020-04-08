package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/8
 * @description: 面试题13. 机器人的运动范围
 */
public class MovingCount {
    public int count = 0;
    public int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int movingCount(int m, int n, int k) {
        int[][] grid = new int[m][n];
        dfs(m, n, 0, 0, k, grid);
        return count;
    }

    public void dfs(int m, int n, int row, int column, int k, int[][] grid) {
        if (row >= 0 && row < m && column >= 0 && column < n && grid[row][column] == 0) {
            int num1 = row;
            int num2 = column;
            int sum = 0;
            while (num1 != 0) {
                sum += num1 % 10;
                num1 = num1 / 10;
            }
            while (num2 != 0) {
                sum += num2 % 10;
                num2 = num2 / 10;
            }
            if (sum <= k) {
                grid[row][column] = 1;
                count++;
                for (int i = 0; i < directions.length; i++) {
                    dfs(m, n, row + directions[i][0], column + directions[i][1], k, grid);
                }
            }
        }
    }
}
