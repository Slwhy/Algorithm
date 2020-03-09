package swordMeansOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author: slwhy
 * @description: 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 * @date: 2019/5/28
 */
public class GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        /**
         * @description 排序法
         * @author slwhy
         * @date 2019/5/28
         * @param input
         * @param k
         * @return java.util.ArrayList<java.lang.Integer>
         */

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k > input.length || k == 0) {
            return res;
        }
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        /**
         * @description 维护一个有序队列，存储最小的前k个数
         * @author slwhy
         * @date 2019/5/28
         * @param input
         * @param k
         * @return java.util.ArrayList<java.lang.Integer>
         */

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k > input.length || k == 0) {
            return res;
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        Collections.sort(res);
        for (int i = k;i<input.length;i++){
            if (input[i]<res.get(k-1)){
                res.remove(k-1);
                res.add(input[i]);
                Collections.sort(res);
            }
        }
        return res;
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k){
        /**
         * @description 利用大根堆实现，不是很理解，待续
         * https://www.nowcoder.com/profile/448404/codeBookDetail?submissionId=1505827
         * @author slwhy
         * @date 2019/5/28
         * @param input
         * @param k
         * @return java.util.ArrayList<java.lang.Integer>
         */

        ArrayList<Integer> res = new ArrayList<Integer>();
        if (k > input.length || k == 0) {
            return res;
        }
        return res;
    }

    public static void main(String[] args) {
        int [] arr = {4,5,1,6,2,7,3,8};
//        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        System.out.println(GetLeastNumbers_Solution1(arr, k));
    }
}
