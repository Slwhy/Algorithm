package leetcode.weeklyContest;


/**
 * @author: slwhy
 * @date: 2020/5/3
 * @description: 5403. 有序矩阵中的第 k 个最小数组和
 */
public class KthSmallest {
    public int kthSmallest(int[][] mat, int k) {
        int[] min = new int[2];
        int minNum = 0;
        int[] index = new int[mat.length];
        for (int i = 0; i < index.length; i++) {
            index[i] = 0;
        }

        int sum = 0;
        while (true) {
            sum = 0;
            for (int i = 0; i < mat.length; i++) {
                sum += mat[i][index[i]];
            }
            k--;
            if (k == 0) break;
            minNum = Integer.MAX_VALUE;
            for (int j = 0; j < mat.length; j++) {
                if (index[j] + 1 < mat[j].length && mat[j][index[j] + 1] < minNum) {
                    min[0] = index[j] + 1;
                    min[1] = j;
                    minNum = mat[j][index[j] + 1];
                }
            }
            index[min[1]] = min[0];
        }

        return sum;
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest = new KthSmallest();
        kthSmallest.kthSmallest(new int[][]{{1, 3, 11}, {2, 4, 6}}, 5);
    }
}
