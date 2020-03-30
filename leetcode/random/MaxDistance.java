package leetcode.random;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/29
 * @description: 1162. 地图分析
 */
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        int dist = 0;
        int curr;
        int[][] tmp = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    for (int row=0;row<grid.length;row++){
                        for (int column =0;column<grid.length;column++){
                            tmp[row][column]=grid[row][column];
                        }
                    }
                    curr = maxDistanceCore(tmp, i, j);
                    dist = Math.max(curr, dist);
                }
            }
        }
        return dist == 0 ? -1 : dist;
    }

    public int maxDistanceCore(int[][] grid, int row, int column) {
        if (row >= 0 && row < grid.length && column >= 0 && column < grid.length && grid[row][column] == 0) {
            grid[row][column] = 2;
            int tmp = Integer.MAX_VALUE;
            int left = maxDistanceCore(grid, row, column - 1);
            int right = maxDistanceCore(grid, row, column + 1);
            int above = maxDistanceCore(grid, row - 1, column);
            int follow = maxDistanceCore(grid, row + 1, column);
            tmp = left >= 0 && left < tmp ? left : tmp;
            tmp = right >= 0 && right < tmp ? right : tmp;
            tmp = above >= 0 && above < tmp ? above : tmp;
            tmp = follow >= 0 && follow < tmp ? follow : tmp;
            return tmp == Integer.MAX_VALUE ? -1 : tmp+1;
        } else if (row >= 0 && row < grid.length && column >= 0 && column < grid.length && grid[row][column] == 1)
            return 0;
        else return -1;
    }

    public static void main(String[] args) {
        MaxDistance dis = new MaxDistance();
        dis.maxDistance(new int[][]{{1,0,0},{0,0,0},{1,0,0}});
    }
}
