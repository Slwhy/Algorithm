package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/20
 * @description: 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    public static int movingCount(int threshold, int rows, int cols) {
        /**
         * @Author slwhy
         * @Date 2019/9/20
         * @Param [threshold, rows, cols]
         * @return int
         * @Description 暴力构造地图
         * 让每位上的数值之和小于指定值比较容易实现，
         * 但是并不是所有满足这个条件的位置都能到达，有些孤立的点是无法从起点抵达的，所以需要构造地图
         **/
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }
        int[][] map = new int[rows][cols];
        map[0][0] = 1;
        int count = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sum = 0;
                int num1 = i;
                int num2 = j;
                while (num1 >= 1) {
                    sum = sum + num1 % 10;
                    num1 = num1 / 10;
                }
                while (num2 >= 1) {
                    sum = sum + num2 % 10;
                    num2 = num2 / 10;
                }
                if (sum <= threshold) {
                    if (i - 1 >= 0) {
                        if (map[i - 1][j] == 1) {
                            count++;
                            map[i][j] = 1;
                            continue;
                        }
                    }
                    if (j - 1 >= 0) {
                        if (map[i][j - 1] == 1) {
                            count++;
                            map[i][j] = 1;
                        }
                    }
                }
            }
        }
        return count;
    }
}
