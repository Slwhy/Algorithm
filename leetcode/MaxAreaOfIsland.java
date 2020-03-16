package leetcode;

/**
 * @author: slwhy
 * @date: 2020/3/15
 * @description: 695. 岛屿的最大面积
 */
public class MaxAreaOfIsland {


    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int tmp;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    tmp = maxAreaOfIslandCore(grid, i, j);
                    max = max > tmp ? max : tmp;
                }
            }
        }
        return max;
    }

    public int maxAreaOfIslandCore(int[][] grid, int i, int j) {
        if ((i >= 0 && i < grid.length) && (j >= 0 && j < grid[0].length) && grid[i][j] == 1) {
            grid[i][j] = 0;
            int left = maxAreaOfIslandCore(grid, i, j - 1);
            int right = maxAreaOfIslandCore(grid, i, j + 1);
            int on = maxAreaOfIslandCore(grid, i + 1, j);
            int low = maxAreaOfIslandCore(grid, i - 1, j);
            return left + right + on + low + 1;
        } else return 0;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        MaxAreaOfIsland max = new MaxAreaOfIsland();
        max.maxAreaOfIsland(array);
    }
}
