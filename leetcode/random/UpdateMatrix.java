package leetcode.random;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2020/4/15
 * @description: 542. 01 矩阵
 */
public class UpdateMatrix {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        /**
         * @Author slwhy
         * @Date 2020/4/15
         * @Param [matrix]
         * @return int[][]
         * @Description leetcode 上的解法
         * 思路：一次前向传播，一次反向传播，
         **/
        int min;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    min = Integer.MAX_VALUE - 1;
                    min = (i - 1 >= 0) ? Math.min(min, matrix[i - 1][j]) : min;
                    min = (j - 1 >= 0) ? Math.min(min, matrix[i][j - 1]) : min;
                    matrix[i][j] = min + 1;
                }
            }
        }

        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][j] != 0) {
                    min = Integer.MAX_VALUE - 1;
                    min = (i + 1 < matrix.length) ? Math.min(min, matrix[i + 1][j]) : min;
                    min = (j + 1 < matrix[i].length) ? Math.min(min, matrix[i][j + 1]) : min;
                    matrix[i][j] = Math.min(matrix[i][j], min + 1);
                }
            }
        }

        return matrix;

    }

    public int[][] updateMatrix1(int[][] matrix) {
        /**
         * @Author slwhy
         * @Date 2020/4/15
         * @Param [matrix]
         * @return int[][]
         * @Description bfs解，参考地图分析那题写的
         **/
        if (matrix.length < 1 || matrix[0].length < 1) return matrix;
        int[][] tag = new int[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    tag[i][j] = 1;
                    queue.add(new int[]{i, j});
                }

            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row;
            int column;
            for (int i = 0; i < directions.length; i++) {
                row = curr[0] + directions[i][0];
                column = curr[1] + directions[i][1];
                //如何不走回头路
                if (row < 0 || column < 0 || row >= matrix.length || column >= matrix[curr[0]].length || tag[row][column] == 1)
                    continue;
                matrix[row][column] = matrix[curr[0]][curr[1]] + 1;
                queue.offer(new int[]{row, column});
                tag[row][column] = 1;
            }
        }

        return matrix;
    }



    public static void main(String[] args) {
        UpdateMatrix updateMatrix = new UpdateMatrix();
        int[][] matrix = new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}};
//        int[][] matrix = new int[][]{{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
        int[][] res = updateMatrix.updateMatrix(matrix);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }

    }
}
