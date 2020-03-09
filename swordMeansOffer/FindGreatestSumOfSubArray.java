package swordMeansOffer;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @date: 2019/9/26
 * @description: 寻找数组中具有最大和的连续字串，数组中元素有正有负
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)
 */
public class FindGreatestSumOfSubArray {

    public static int findGreatestSumOfSubArray4(int[] array) {
        /**
         * @Author slwhy
         * @Date 2019/10/11
         * @Param [array]
         * @return int
         * @Description 过了一段时间后，自己写出来的
         **/
        int lent = array.length;
        if (lent < 1) return 0;
        int max = array[0];
        int sum = array[0];
        for (int i = 1; i < lent; i++) {
            //max = Math.max(Math.max(sum + array[i], sum), Math.max(array[i], max));
            if (sum < 0) {//sum<0则sum+array[i]<array[i]
                sum = array[i];
            } else sum = sum + array[i];
            max = Math.max(max, sum);// max的赋值放后面的话，就只需要取max和sum的最大值了,因为经过前面的if else 就已经把array[i]和sum+array[i]的最大值筛出来了

        }
        return max;
    }

    public static int findGreatestSumOfSubArray3(int[] array) {
        /**
         * @Author slwhy
         * @Date 2019/9/26
         * @Param [array]
         * @return int
         * @Description 思考一下，如何将这个子串如何保留下来
         **/
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        ArrayList<Integer> sub = new ArrayList<>();
        int res = array[0];
        int max = array[0];
        boolean isAdd;
        boolean isNew;
        sub.add(array[0]);
        for (int i = 1; i < array.length; i++) {
            isAdd = false;
            isNew = false;
            if (max + array[i] > array[i]) {
                max = max + array[i];
                isAdd = true;
            } else {
                max = array[i];
                isNew = true;
            }
            if (max > res) {
                res = max;
                if (isNew) {
                    sub.clear();
                }
            }
            sub.add(array[i]);
        }
        for (int i = 0; i < sub.size(); i++) {
            System.out.print(array[i]);
            System.out.print("\t");
        }
        System.out.print("\n");
        return res;
    }

    public static int findGreatestSumOfSubArray2(int[] array) {
        /**
         * @Author slwhy
         * @Date 2019/9/26
         * @Param [array]
         * @return int
         * @Description 理解了牛客上的代码，自己写出来的
         * 思路：用f(i-1)表示前i-1个元素中的最大和，当面临array中的一个元素Ai时，有三种情况，
         * 一是f(i)=f(i-1)
         * 二是f(i)=Ai
         * 三是2f(i)=f(i-1)+Ai
         **/
        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        int res = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = (max + array[i]) > array[i] ? (max + array[i]) : array[i];
            res = max > res ? max : res;
        }
        return res;
    }

    public static int findGreatestSumOfSubArray(int[] array) {
        /**
         * @Author slwhy
         * @Date 2019/9/26
         * @Param [array]
         * @return int
         * @Description 牛客的代码 https://www.nowcoder.com/profile/9268219/codeBookDetail?submissionId=20063227
         **/
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max = array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(findGreatestSumOfSubArray3(array));
    }
}
