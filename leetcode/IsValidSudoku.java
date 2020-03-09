package leetcode;

import java.util.HashSet;

/**
 * @author: slwhy
 * @date: 2019/11/22
 * @description: num 36
 */
public class IsValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        HashSet nums = new HashSet();
        for (int i = 0; i < board.length; i++) {
            nums.clear();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (nums.contains(board[i][j])) return false;
                    else nums.add(board[i][j]);
                }
            }
        }
        for (int j = 0; j < board[0].length; j++) {
            nums.clear();
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] != '.') {
                    if (nums.contains(board[i][j])) return false;
                    else nums.add(board[i][j]);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nums.clear();
                for (int m = i * 3; m < i * 3 + 3; m++) {
                    for (int n = j * 3; n < j * 3 + 3; n++) {
                        if (board[m][n] != '.') {
                            if (nums.contains(board[m][n])) return false;
                            else nums.add(board[m][n]);
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku(chars));
    }
}
