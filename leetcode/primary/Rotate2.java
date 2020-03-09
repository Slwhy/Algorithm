package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/8
 * @description: 旋转图像
 */
public class Rotate2 {
    public void rotate(int[][] matrix) {
        rotateCore(matrix, 0);
    }

    public void rotateCore(int[][] matrix, int layer) {
        /**
         * @Author slwhy
         * @Date 2020/3/8
         * @Param [matrix, layer]
         * @return void
         * @Description 每次选择一圈，共旋转n圈，且 n<matrix.length/2,
         * 要注意边界就是了，特别是每一圈要旋转多少个元素
         **/
        if (layer < matrix.length / 2) {
            int tmp;
            for (int i = layer; i < (matrix.length - layer) - 1; i++) {
                tmp = matrix[layer][i];
                matrix[layer][i] = matrix[matrix.length - i - 1][layer];
                matrix[matrix.length - i - 1][layer] = matrix[matrix.length - layer - 1][matrix.length - i - 1];
                matrix[matrix.length - layer - 1][matrix.length - i - 1] = matrix[i][matrix.length - layer - 1];
                matrix[i][matrix.length - layer - 1] = tmp;
            }
            rotateCore(matrix, layer + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil((double) 3 / 2));
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        Rotate2 rotate2 = new Rotate2();
        rotate2.rotate(matrix);
    }
}
