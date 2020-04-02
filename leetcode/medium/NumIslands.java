package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/1
 * @description: 200. 岛屿数量
 */
public class NumIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid.length < 1) return res;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }

    public static void main(String[] args) {

    }
}
