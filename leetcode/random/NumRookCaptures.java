package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/3/26
 * @description: 999. 车的可用捕获量
 */
public class NumRookCaptures {
    public int numRookCaptures(char[][] board) {
        int[] rows = new int[]{0, 0, 1, -1};
        int[] columns = new int[]{1, -1, 0, 0};
        int count = 0;
        int row;
        int column;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    for (int index = 0; index < 4; index++) {
                        row = i;
                        column = j;
                        while (row >= 0 && row < board.length && column >= 0 && column < board[0].length && board[row][column] != 'B') {
                            if (board[row][column] == 'p') {
                                count++;
                                break;
                            }
                            row += rows[index];
                            column += columns[index];
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumRookCaptures rook = new NumRookCaptures();
        char[][] board = new char[][]{{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', 'R', '.', '.', '.', 'p'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', 'p', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};
        System.out.println(rook.numRookCaptures(board));
    }

}
