package leetcode.primary;

import java.util.HashSet;

/**
 * @author: slwhy
 * @date: 2020/3/9
 * @description: 有效的数独
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        /**
         * @Author slwhy
         * @Date 2020/3/10
         * @Param [board]
         * @return boolean
         * @Description leetcode 上的解法，一次遍历
         * 重点是当前节点到子数独的映射
         **/
        if (board.length != 9 || board[0].length != 9) return false;
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] columns = new HashSet[9];
        HashSet<Integer>[] boxs = new HashSet[9];
        int boxsIndex;
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxs[i] = new HashSet<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    boxsIndex = (i / 3) * 3 + j / 3;
                    int n = (int) board[i][j];
                    if (rows[i].contains(n) || columns[j].contains(n) || boxs[boxsIndex].contains(n)) return false;
                    else {
                        rows[i].add(n);
                        columns[j].add(n);
                        boxs[boxsIndex].add(n);
                    }
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        /**
         * @Author slwhy
         * @Date 2020/3/10
         * @Param [board]
         * @return boolean
         * @Description 暴力解法，三次遍历
         **/
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
        System.out.println((int) '3' - (int) '0');
    }
}
