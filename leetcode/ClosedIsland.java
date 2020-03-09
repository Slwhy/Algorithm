package leetcode;

/**
 * @author: slwhy
 * @date: 2019/11/17
 * @description: num 1254
 */
public class ClosedIsland {


    public static int closedIsland(int[][] grid) {
        //leetcode上的解法
        if (grid.length < 1 || grid[0].length < 1) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    res += closedIslandCore(grid, i, j);
                }
            }
        }
        return res;
    }

    public static int closedIslandCore(int[][] grid, int row, int column) {
        if (row < 0 || column < 0 || row >= grid.length || column >= grid[0].length) return 0;
        if (grid[row][column] == 1) return 1;
        grid[row][column] = 1;
        int left = closedIslandCore(grid, row, column - 1);
        int top = closedIslandCore(grid, row - 1, column);
        int right = closedIslandCore(grid, row, column + 1);
        int bottom = closedIslandCore(grid, row + 1, column);
        //不能定义一个成员变量，当满足下列条件就++，这样会导致重复计算，因为当前这个点满足条件，递归返回上一层的时候也可能满足条件
        if (left == 1 && top == 1 && right == 1 && bottom == 1) return 1;
        return 0;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        System.out.println(closedIsland(array));
    }


}
