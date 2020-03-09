package swordMeansOffer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author: slwhy
 * @date: 2019/9/20
 * @description: 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}
 */
public class MaxInWindows {

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        /**
         * @Author slwhy
         * @Date 2019/9/20
         * @Param [num, size]
         * @return java.util.ArrayList<java.lang.Integer>
         * @Description 暴力
         **/
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (size > num.length || num.length < 1 || size < 1) {
            return res;
        }
        for (int i = 0; i <= num.length - size; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + size; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            res.add(max);
        }
        return res;
    }

    public ArrayList<Integer> maxInWindows1(int[] num, int size) {
        /**
         * @Author slwhy
         * @Date 2019/9/20
         * @Param [num, size]
         * @return java.util.ArrayList<java.lang.Integer>
         * @Description 参考 https://www.cnblogs.com/wupeixuan/p/8881868.html
         **/
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (num == null || num.length < size || size < 1) {
            return ret;
        }
        LinkedList<Integer> indexDeque = new LinkedList<Integer>();
        for (int i = 0; i < size - 1; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
        }

        for (int i = size - 1; i < num.length; i++) {
            while (!indexDeque.isEmpty() && num[i] > num[indexDeque.getLast()]) {
                indexDeque.removeLast();
            }
            indexDeque.addLast(i);
            if (i - indexDeque.getFirst() + 1 > size) {
                indexDeque.removeFirst();
            }
            ret.add(num[indexDeque.getFirst()]);
        }
        return ret;
    }
}
