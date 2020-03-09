package leetcode;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/3
 * @description: 面试题 10.01
 */
public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
        /**
         * @Author slwhy
         * @Date 2020/3/3
         * @Param [A, m, B, n]
         * @return void
         * @Description 双指针，A数组最右边是空着的，且有足够的空间能够放下B数组
         *按照从大到小的顺序，将最大的数放到 A[m+n-1]上，这就转化成了常见的合并两个有序数组的问题，
         * 而且因为 起始位置是 A[m+n-1]，即使 B 数组全部放进去，也不用担心数据会覆盖了原始A数组的数据
         **/
        int i = m + n - 1;
        int disA = m - 1;
        int disB = n - 1;
        while (i >= 0 && disA >= 0 && disB >= 0) {
            if (A[disA] > B[disB]) A[i--] = A[disA--];
            else A[i--] = B[disB--];
        }
        while (disB >= 0 && i >= 0) {
            A[i--] = B[disB--];
        }
    }

    public void merge3(int[] A, int m, int[] B, int n) {
        /**
         * @Author slwhy
         * @Date 2020/3/3
         * @Param [A, m, B, n]
         * @return void
         * @Description 利用一个临时数组暂存 A 中的有效数据，就变成了普通的合并两个有序数组问题
         **/
        if (n > 0) {
            int[] tmp = new int[m];
            for (int i = 0; i < m; i++) {
                tmp[i] = A[i];
            }
            int disTmp = 0, disB = 0;
            int i = 0;
            while (disTmp < m && disB < n && i < m + n) {
                if (tmp[disTmp] < B[disB]) {
                    A[i++] = tmp[disTmp++];
                } else A[i++] = B[disB++];
            }
            while (disB < n) A[i++] = B[disB++];
            while (disTmp < m) A[i++] = tmp[disTmp++];
        }
    }

    public void merge2(int[] A, int m, int[] B, int n) {
        /**
         * @Author slwhy
         * @Date 2020/3/3
         * @Param [A, m, B, n]
         * @return void
         * @Description 除了两数交换使用的中间变量，不用申请其他空间，但是每次必须保持B数组有序，时间复杂度 m*n*log(n)
         **/
        if (n > 0) {
            int tmp;
            for (int i = 0; i < m; i++) {
                if (A[i] > B[0]) {
                    tmp = A[i];
                    A[i] = B[0];
                    B[0] = tmp;
                    Arrays.sort(B);
                }
            }
            for (int i = m; i < m + n; i++) {
                A[i] = B[i - m];
            }
        }

    }
}
