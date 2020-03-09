package swordMeansOffer;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @description: 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵：
 *      1  2  3  4
 *     5  6  7  8
 *     9 10 11 12
 *     13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * @date: 2019/5/3
 */
public class PrintMatrix {
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        /**
         * @description 将打印拆解成四部分，每条边一个循环，每完成一圈会减少两行，两列；
         * 即起始行号加一，终止行号减一；起始列号加一，终止列号减一
         * 要注意执行后两个循环的时候要进行判断，因为前两个循环执行后，行列各减一，
         * @author slwhy
         * @date 2019/5/3
         * @param matrix
         * @return java.util.ArrayList<java.lang.Integer>
         */

        int line = matrix.length;
        int column = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = 0;
        while (2*n<line&&2*n<column){
            for (int i = n;i<column-n;i++){
                res.add(matrix[n][i]);
            }
            for (int i = n+1;i<line-n;i++){
                res.add(matrix[i][column-n-1]);
            }
            if (2*n+1<line){
                for (int i = column-n-1-1;i>=n;i--){
                    res.add(matrix[line-n-1][i]);
                }
            }
            if (2*n+1<column){
                for (int i = line-n-1-1;i>n;i--){
                    res.add(matrix[i][n]);
                }
            }

            n++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int [][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
//        int [][] input = {{1},{2},{3},{4}};
//        int [][] input = {{1,2,3,4}};
//        int [][] input = {{1,2},{3,4},{5,6},{7,8}};
        int [][] input = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        ArrayList<Integer> a = printMatrix(input);
        for (int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }

    }
}
