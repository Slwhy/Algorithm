package swordMeansOffer;

import java.util.HashMap;


/**
 * @author: slwhy
 * @description: 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 * @date: 2019/8/28
 */
public class FindNumsAppearOnce {

    public static void findNumsAppearOnce(int[] array, int num1[], int num2[]) {
        /**
        * @Author slwhy
        * @Date 2019/8/29
        * @Param [array, num1, num2]
        * @return void
        * @Description //用hashmap实现，
         * 牛客网上有一个用位运算实现的 https://www.nowcoder.com/profile/3648374/codeBookDetail?submissionId=19823461
        **/
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {

            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }

        }
        int[] res = new int[2];
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1) {
                res[n] = array[i];
                n++;
            }
        }
        num1[0] = res[0];
        num2[0] = res[1];

    }

    public static void main(String[] args) {
        int[] array = new int[] {1,2,3,4,5,2,3,4};
        int [] num1 = new int[1];
        int[] num2 = new int[1];
        findNumsAppearOnce(array,num1,num2);
        System.out.println(num1[0]);
    }
}
