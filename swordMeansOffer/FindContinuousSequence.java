package swordMeansOffer;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @description: 找出所有和为S的连续正数序列
 * 如：连续正数和为100的序列:[9,10,11,12,13,14,15,16],[18,19,20,21,22]
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * @date: 2019/9/2
 */
public class FindContinuousSequence {
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        /**
        * @Author slwhy
        * @Date 2019/9/2
        * @Param [sum]
        * @return java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
        * @Description
         * 我的思路:因为是等差数列，即可以根据等差数列求和公式，sum/n得到的应该是这个数列的中间这个元素，
         *         而后根据这个元素以及n的长度向两边扩展，即可得到该数列（要对数列进行验证，验证和是否为sum，输出结果根据每个数列的第一个值排序）
         * 牛客：双端指针，很好的思路，可以借鉴一下
         *  https://www.nowcoder.com/profile/645151/codeBookDetail?submissionId=1519890
        **/
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        //sum = (1 + n) * n / 2，所以可以确定i的最大值
        for (int i = (int) Math.sqrt(2 * sum); i > 2; i--) {
            ArrayList<Integer> current = new ArrayList<Integer>();
            if (i % 2 != 0) {
                if (sum % i == 0) {//i为奇数时，sum = i*中间值
                    for (int j = sum / i - ((i - 1) / 2); j <= sum / i + ((i - 1) / 2); j++) {
                        current.add(j);
                    }
                } else continue;
            } else {//i为偶数时，sum=中间两个值的平均值*i
                if (sum == (sum / i + sum / i + 1) * i / 2) {
                    for (int j = sum / i - i / 2 + 1; j <= sum / i + i / 2; j++) {
                        current.add(j);
                    }
                }
            }
            if (!current.isEmpty()) {
                res.add(current);
            }
        }
        return res;
    }

}
