package leetcode.random;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2020/3/29
 * @description: 1162. 地图分析
 */
public class MaxDistance {
    public int maxDistance(int[][] grid) {
        /**
         * @Author slwhy
         * @Date 2020/3/31
         * @Param [grid]
         * @return int
         * @Description leetcode上的解法
         **/
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new ArrayDeque<>();
        int m = grid.length, n = grid[0].length;
        // 先把所有的陆地都入队。
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            // 取出队列的元素，将其四周的海洋入队。
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0) {
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1; // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                hasOcean = true;
                queue.offer(new int[] {newX, newY});
            }
        }
        if (point == null || !hasOcean) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }



    public static void main(String[] args) {
        MaxDistance dis = new MaxDistance();
        dis.maxDistance(new int[][]{{1,0,0},{0,0,0},{1,0,0}});
    }
}
