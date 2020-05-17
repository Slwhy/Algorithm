package leetcode.weeklyContest;

import leetcode.random.MaxQueue;

/**
 * @author: slwhy
 * @date: 2020/5/17
 * @description: 5415. 圆形靶内的最大飞镖数量
 */
public class NumPoints {

    public int max = 0;

    public int numPoints(int[][] points, int r) {

        int rowSum = 0;
        int columnSum = 0;
        for (int i = 0; i < points.length; i++) {
            rowSum += points[i][0];
            columnSum += points[i][1];
        }

        dfs(points, r, points.length, rowSum, columnSum, points.length - 1);
        return max;
    }

    public void dfs(int[][] points, int r, int count, double rowSum, double columnSum, int index) {
        if (count > 0 && count > max) {
            for (int i = index; i > 0; i--) {
                dfs(points, r, count - 1, rowSum - points[index][0], columnSum - points[index][1], i - 1);
            }
            int num = 0;
            double row = rowSum / count;
            double column = columnSum / count;
            for (int i = 0; i < points.length; i++) {
                if (Math.pow(row - points[i][0], 2) + Math.pow(column - points[i][1], 2) <= r * r) {
                    num++;
                }
            }
            max = Math.max(max, num);

        }
    }

    public static void main(String[] args) {
        NumPoints numPoints = new NumPoints();
        System.out.println(numPoints.numPoints(new int[][]{{-3, 0}, {3, 0}, {2, 6}, {5, 4}, {0, 9}, {7, 8}}, 5));
    }
}
