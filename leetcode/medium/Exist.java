package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/3
 * @description: 79. 单词搜索
 */
public class Exist {

    int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    char[][] copyBoard = new char[board.length][board[0].length];
                    for (int m = 0; m < board.length; m++) {
                        for (int n = 0; n < board[0].length; n++) {
                            copyBoard[m][n] = board[m][n];
                        }
                    }
                    boolean res = dfs(copyBoard, i, j, new StringBuilder(), word);
                    if (res) return res;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int column, StringBuilder path, String word) {
        if (row >= 0 && row < board.length && column >= 0 && column < board[row].length && board[row][column] != '0') {
            path.append(board[row][column]);
            board[row][column] = '0';
            if (path.length() < word.length()) {
                boolean curr = false;
                for (int i = 0; i < directions.length; i++) {
                    curr = curr || dfs(board, row + directions[i][0], column + directions[i][1], new StringBuilder(path), word);
                }
                return curr;
            } else return path.toString().equals(word);
        } else return false;
    }

    public static void main(String[] args) {
        StringBuilder test = new StringBuilder();
        test.append("abcd");
        System.out.println(test.delete(test.length() - 1, test.length()));
    }
}
