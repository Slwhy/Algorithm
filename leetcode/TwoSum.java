package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: slwhy
 * @date: 2019/10/7
 * @description: num 1
 */
public class TwoSum {

    public static int[] twoSum2(int[] nums, int target) {
        /**
         * @Author slwhy
         * @Date 2019/10/7
         * @Param [nums, target]
         * @return int[]
         * @Description 利用map记录数组中的数以及下标，以空间换时间
         **/
        int[] res = new int[2];
        if (nums.length < 2) return res;
        Map<Integer, Integer> numMap = new HashMap();
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            tmp = target - nums[i];
            if (numMap.keySet().contains(tmp) && !numMap.get(tmp).equals(i)) {
                res[0] = i;
                res[1] = numMap.get(tmp);
                break;
            }
        }
        return res;
    }

    public static int[] twoSum(int[] nums, int target) {
        /**
         * @Author slwhy
         * @Date 2019/10/7
         * @Param [nums, target]
         * @return int[]
         * @Description 暴力
         **/
        int[] res = new int[2];
        if (nums.length < 2) return res;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 4};
        int[] res = new int[2];
        res = twoSum2(array, 6);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
