package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/2
 * @description: 289. 生命游戏
 */
public class GameOfLife {
    private static final int[] DX = {0, 0, 1, -1, 1, 1, -1, -1};
    private static final int[] DY = {1, -1, 0, 0, 1, -1, 1, -1};

    public void gameOfLife(int[][] board) {
        /**
         * @Author slwhy
         * @Date 2020/4/2
         * @Param [board]
         * @return void
         * @Description leetcode上的解法，
         * 利用int 32位，第一位存储当前的状态，第二位存储刷新后的状态，（cell只有0，1两种状态）
         **/
        if (board.length == 0) {
            return;
        }
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                int cnt = 0;
                for (int k = 0; k < 8; k++) {
                    int x = i + DX[k];
                    int y = j + DY[k];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                        continue;
                    }
                    // 这里不能直接加board[x][y]，因为 board[x][y] 的倒数第二位是可能有值的。
                    cnt += board[x][y] & 1;
                }
                if ((board[i][j] & 1) > 0) {
                    // 这个是活细胞
                    if (cnt >= 2 && cnt <= 3) {
                        // 周围有2/3个活细胞，下一个状态还是活细胞。
                        board[i][j] = 0b11;
                    }
                    // 周围活细胞过多或过少都会死，因为原数据是0b01，所以这里不用额外赋值。
                } else if (cnt == 3) {
                    // 这个是死细胞，周围有3个活细胞，下一个状态变为活细胞。
                    board[i][j] = 0b10;
                }
            }
        }
        // 最后一位去掉，倒数第二位变为更新后的状态。
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                board[i][j] >>= 1;
            }
        }
    }

    public void gameOfLife2(int[][] board) {
        /**
         * @Author slwhy
         * @Date 2020/4/2
         * @Param [board]
         * @return void
         * @Description 自己想出来的，开辟一个额外的数组进行变化
         **/
        if (board.length < 1) return;
        int[][] boardCopy = new int[board.length][board[0].length];
        int[][] directions = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int count;
        int row;
        int column;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                count = 0;
                for (int d = 0; d < directions.length; d++) {
                    row = i + directions[d][0];
                    column = j + directions[d][1];
                    if (row >= 0 && row < board.length && column >= 0 && column < board[i].length) {
                        if (board[row][column] == 1) count++;
                    }
                }
                if (count < 2 || count > 3) boardCopy[i][j] = 0;
                if (count == 3) boardCopy[i][j] = 1;
                if (count == 2) boardCopy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = boardCopy[i][j];
            }
        }
    }

    public static void main(String[] args) {

    }
}
