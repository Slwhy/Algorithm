package leetcode.weeklyContest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: slwhy
 * @date: 2020/4/12
 * @description: 5383. 给 N x 3 网格图涂色的方案数
 */
public class NumOfWays {
    int count = 0;

    public int numOfWays(int n) {
        int[][] grid = new int[n][3];
        for (int i=0;i<3;i++){
            helper(grid, 0, 0, n, i);
        }
        return count;
    }

    public void helper(int[][] grid, int row, int column, int n, int tag) {
        if (row >= 0 && column >= 0 & row < n && column < 3) {
            if (row == n - 1 && column == 2) count++;
            grid[row][column] = tag;
            for (int i = 0; i < 3; i++) {
                if (i != tag) {
                    helper(grid, row + 1, column, n, i);
                    helper(grid, row, column + 1, n, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumOfWays numOfWays = new NumOfWays();
        System.out.println(numOfWays.numOfWays(2));
    }
}
