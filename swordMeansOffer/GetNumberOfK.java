package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 统计一个数字在排序数组中出现的次数
 * @date: 2019/8/27
 */
public class GetNumberOfK {
    public static int getNumberOfK(int[] array, int k) {
        /**
         * @description
         * @author slwhy
         * @date 2019/8/27
         * @param array
         * @param k
         * @return int
         */

        if (array.length < 1) {
            return 0;
        }
        int n = 0;
        if (array[0] < array[array.length - 1]) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == k) {
                    n++;
                }
                if (array[i] > k) {
                    break;
                }
            }
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == k) {
                    n++;
                }
                if (array[i] < k) {
                    break;
                }
            }
        }

        return n;
    }

}
