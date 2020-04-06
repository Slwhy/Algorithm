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
                boolean res = dfs(board, i, j, 0, word);
                if (res) return res;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int column, int index, String word) {
        if (row >= 0 && row < board.length && column >= 0 && column < board[row].length && index < word.length() && board[row][column] == word.charAt(index)) {
            if (index == word.length() - 1) return true;
            else {
                boolean flag = false;
                char tmp = board[row][column];
                board[row][column] = '0';
                for (int i = 0; i < directions.length; i++) {
                    flag = flag || dfs(board, row + directions[i][0], column + directions[i][1], index + 1, word);
                }
                board[row][column] = tmp;
                return flag;
            }
        } else return false;
    }

    public static void main(String[] args) {
        Exist exist = new Exist();
//        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));
        System.out.println(exist.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'E', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCESEEEFS"));

    }
}
