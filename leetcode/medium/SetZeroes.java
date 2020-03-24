package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: slwhy
 * @date: 2020/3/23
 * @description: 73. 矩阵置零
 */
public class SetZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length < 0) return;
        boolean[] rows = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    column[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] || column[j]) matrix[i][j] = 0;
            }
        }
    }

    public void setZeroes1(int[][] matrix) {
        Set<Integer> rows = new HashSet();
        Set<Integer> column = new HashSet();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    column.add(j);
                }
            }
        }
        for (Integer i : rows) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = 0;
            }
        }
        for (Integer j : column) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        boolean[] tmp = new boolean[1];
        System.out.println(tmp[0]);
    }
}
