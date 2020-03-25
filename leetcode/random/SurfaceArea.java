package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/3/25
 * @description: 892. 三维形体的表面积
 */
public class SurfaceArea {


    public int surfaceArea1(int[][] grid) {
        int count = 0;
        int cover = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                count += grid[i][j];
                cover = cover + (grid[i][j] > 0 ? grid[i][j] - 1 : 0) * 2;
                if (i - 1 >= 0) {
                    cover += Math.min(grid[i][j], grid[i - 1][j]);
                }
                if (i + 1 < grid.length) {
                    cover += Math.min(grid[i][j], grid[i + 1][j]);
                }
                if (j - 1 >= 0) {
                    cover += Math.min(grid[i][j - 1], grid[i][j]);
                }
                if (j + 1 < grid[0].length) {
                    cover += Math.min(grid[i][j], grid[i][j + 1]);
                }
            }
        }
        return count * 6 - cover;
    }
}
