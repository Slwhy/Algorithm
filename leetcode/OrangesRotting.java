package leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/3/4
 * @description: num 994
 */
public class OrangesRotting {

    public static int orangesRotting(int[][] grid) {
        /**
         * @Author slwhy
         * @Date 2020/3/5
         * @Param [grid]
         * @return int
         * @Description BFS解法，根据腐败橘子的传播特性，比较符合BFS的特点，将初始的所有腐败橘子进队列，
         * 而后利用这些腐败橘子分别对周围的橘子进行感染，直至队列为空，最后，如果有好橘子则返回-1，否则返回所有橘子中耗时最长的
         **/
        int time = 0;
        Queue<int[]> queue1 = new LinkedList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    int[] tmp = new int[3];
                    tmp[0] = i;
                    tmp[1] = j;
                    tmp[2] = 0;
                    queue1.add(tmp);
                }
            }
        }

        while (!queue1.isEmpty()) {
            int[] curr = queue1.poll();
            if (curr[2] > time) time = curr[2];
            if (curr[0] > 0 && grid[curr[0] - 1][curr[1]] == 1) {
                int[] tmp = new int[3];
                tmp[0] = curr[0] - 1;
                tmp[1] = curr[1];
                tmp[2] = curr[2] + 1;
                queue1.add(tmp);
                grid[curr[0] - 1][curr[1]] = 2;

            }
            if (curr[0] < grid.length - 1 && grid[curr[0] + 1][curr[1]] == 1) {
                int[] tmp = new int[3];
                tmp[0] = curr[0] + 1;
                tmp[1] = curr[1];
                tmp[2] = curr[2] + 1;
                queue1.add(tmp);
                grid[curr[0] + 1][curr[1]] = 2;

            }
            if (curr[1] > 0 && grid[curr[0]][curr[1] - 1] == 1) {
                int[] tmp = new int[3];
                tmp[0] = curr[0];
                tmp[1] = curr[1] - 1;
                tmp[2] = curr[2] + 1;
                queue1.add(tmp);
                grid[curr[0]][curr[1] - 1] = 2;

            }
            if (curr[1] < grid[0].length - 1 && grid[curr[0]][curr[1] + 1] == 1) {
                int[] tmp = new int[3];
                tmp[0] = curr[0];
                tmp[1] = curr[1] + 1;
                tmp[2] = curr[2] + 1;
                queue1.add(tmp);
                grid[curr[0]][curr[1] + 1] = 2;

            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return time;
    }

    public int orangesRotting2(int[][] grid) {
        /**
         * @Author slwhy
         * @Date 2020/3/4
         * @Param [grid]
         * @return int
         * @Description 用一个3表示刚刚感染导致腐败的橘子，因为在每一轮传播中，这类橘子不会导致新的橘子腐败
         *然后就是循环多次传播，直至腐败橘子数不再增加或者说，腐败橘子数等于橘子总数
         **/
        int orangeCount = 0;
        int rotOrangeCount = 0;
        int rotOrangeCountLast = 0;
        int time = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 || grid[i][j] == 2) orangeCount++;
                if (grid[i][j] == 2) rotOrangeCount++;
            }
        }
        while (orangeCount > rotOrangeCount && rotOrangeCount > rotOrangeCountLast) {
            time++;
            rotOrangeCountLast = rotOrangeCount;
            rotOrangeCount = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        if (i > 0) {
                            if (grid[i - 1][j] == 2) {
                                grid[i][j] = 3;
                                continue;
                            }
                        }
                        if (i < grid.length - 1) {
                            if (grid[i + 1][j] == 2) {
                                grid[i][j] = 3;
                                continue;
                            }
                        }
                        if (j > 0) {
                            if (grid[i][j - 1] == 2) {
                                grid[i][j] = 3;
                                continue;
                            }
                        }
                        if (j < grid[i].length - 1) {
                            if (grid[i][j + 1] == 2) {
                                grid[i][j] = 3;
                            }
                        }

                    }
                }
            }
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 3) grid[i][j] = 2;
                    if (grid[i][j] == 2) rotOrangeCount++;
                }
            }
        }
        if (rotOrangeCount == orangeCount) return time;
        else return -1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{2}, {1}, {1}, {1}, {2}, {1}, {1}};
        System.out.println(orangesRotting(grid));
    }
}
