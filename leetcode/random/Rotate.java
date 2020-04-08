package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/7
 * @description: 面试题 01.07. 旋转矩阵
 */
public class Rotate {
    public void rotate(int[][] matrix) {
        int tmp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
                matrix[i][matrix[i].length - j - 1] = tmp;
            }
        }
    }
}
