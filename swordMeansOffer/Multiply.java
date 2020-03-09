package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/5
 * @description: 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法
 * 即B[i]=A中的除下标为i的累乘
 * 如果可以用除法则贼简单，直接求出所有的积，而后挨个除以A[i]即得到B[i]
 * 时间复杂度为，O(n);空间复杂度,O(1)
 */
public class Multiply {
    public int[] multiply2(int[] A) {
        /**
         * @Author slwhy
         * @Date 2019/9/5
         * @Param [A]
         * @return int[]
         * @Description
         * 牛客上的思路，
         *  https://www.nowcoder.com/profile/6151151/codeBookDetail?submissionId=20269491
         *  O(n)的时间复杂度，
         *  第一遍循环，令B[i]=A[i-1]*A[i-2]*...*A[0]
         *  第二遍循环，B[j]=B[j]*temp ,temp = A[lent-1]*A[lent-2]*...A[j+1]
         **/
        int length = A.length;
        int[] B = new int[length];
        //计算下三角连乘
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        //计算上三角
        for (int j = length - 2; j >= 0; j--) {
            temp *= A[j + 1];
            B[j] *= temp;
        }

        return B;
    }

    public static int[] multiply(int[] A) {
        /**
         * @Author slwhy
         * @Date 2019/9/5
         * @Param [A]
         * @return int[]
         * @Description
         * 暴力解法
         **/
        int[] b = new int[A.length];
        int res;
        for (int i = 0; i < A.length; i++) {
            res = 1;
            for (int j = 0; j < A.length; j++) {
                if (i != j) {
                    res = res * A[j];
                }
            }
            b[i] = res;
        }
        return b;
    }

}
