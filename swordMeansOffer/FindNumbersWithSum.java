package swordMeansOffer;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @description: 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的
 * @date: 2019/9/2
 */
public class FindNumbersWithSum {
    public static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {
        /**
        * @Author slwhy
        * @Date 2019/9/2
        * @Param [array, sum]
        * @return java.util.ArrayList<java.lang.Integer>
        * @Description 典型思路（要掌握），利用两个指针分别两端开始遍历，根据大小调整两个指针
        **/
        ArrayList<Integer> res = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        int pleft = 0;
        int pright = array.length - 1;
        while (pleft < array.length - 1 && pright > pleft) {
            if (array[pleft] + array[pright] == sum) {
                if (array[pleft] * array[pright] < min) {
                    res.add(0, array[pleft]);
                    res.add(1, array[pright]);
                    min = array[pleft] * array[pright];
                }

                pleft++;
            }
            if (array[pleft] + array[pright] < sum) {
                pleft++;
            }
            if (array[pleft] + array[pright] > sum) {
                pright--;
            }
        }

        return res;
    }


}
