package swordMeansOffer;

import java.util.HashMap;


/**
 * @author: slwhy
 * @description: 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0
 * @date: 2019/5/28
 */
public class MoreThanHalfNum {
    public static int MoreThanHalfNum_Solution(int[] array) {
        /**
         * @description 我的思路，利用hashmap进行统计所有的数出现的次数，而后进行判断
         * @author slwhy
         * @date 2019/5/28
         * @param array
         * @return int
         */

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int key;
        for (int i = 0; i < array.length; i++) {
            key = array[i];
            if (!map.containsKey(String.valueOf(key))) {
                map.put(String.valueOf(key), 1);
            } else {
                Integer value = map.get(String.valueOf(key));
                value++;
                map.put(String.valueOf(key), value);
            }
        }
        for (String num : map.keySet()) {
            if (map.get(num) > array.length / 2) {
                return Integer.valueOf(num);
            }
        }
        return 0;
    }

    public static int MoreThanHalfNum_Solution2(int[] array) {
        /**
         * @description 参考牛客代码
         * https://www.nowcoder.com/profile/519263/codeBookDetail?submissionId=1520973
         * 解释一下，为什么要验证，因为如果当遍历到数组末尾时count为0，
         * 则count++为1，但可能末尾这个值出现次数很少，如main函数中的测试用例
         * @author slwhy
         * @date 2019/5/28
         * @param array
         * @return int
         */

        int count = 0;
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
            }
            if (num == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        //验证
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            }
        }
        return count > array.length/2 ? num : 0;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] arr = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        System.out.println(MoreThanHalfNum_Solution2(arr));
    }
}
