package leetcode.weeklyContest;

import java.util.HashMap;


/**
 * @author: slwhy
 * @date: 2020/5/30
 * @description: 5411. 摘樱桃 II
 */
public class CherryPickup {
    int[] direct = new int[]{-1, 0, 1};
    HashMap<String, Integer> memary = new HashMap<>();

    public int cherryPickup(int[][] grid) {
        return dfs(grid, 0, 0, 0, grid[0].length - 1);
    }

    public int dfs(int[][] grid, int r1Row, int r1Col, int r2Row, int r2Col) {
        if (0 <= r1Row && r1Row < grid.length && 0 <= r1Col && r1Col < grid[0].length && 0 <= r2Row && r2Row <= grid.length && 0 <= r2Col && r2Col < grid[0].length) {
            String key = Integer.toString(r1Row) + Integer.toString(r1Col) + Integer.toString(r2Row) + Integer.toString(r2Col);
            if (memary.keySet().contains(key)) return memary.get(key);
            int max = 0;
            int num;
            int curr;
            if (r1Col == r2Col && r1Row == r2Row) curr = grid[r1Row][r1Col];
            else curr = grid[r1Row][r1Col] + grid[r2Row][r2Col];
            for (int i : direct) {
                for (int j : direct) {
                    num = curr + dfs(grid, r1Row + 1, r1Col + i, r2Row + 1, r2Col + j);
                    max = Math.max(max, num);
                }
            }
            memary.put(key,max);
            return max;
        } else return 0;
    }
}
