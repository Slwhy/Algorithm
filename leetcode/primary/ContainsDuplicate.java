package leetcode.primary;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: slwhy
 * @date: 2020/3/7
 * @description: 存在重复
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/7
         * @Param [nums]
         * @return boolean
         * @Description 常见解法
         * 1.n^2 级别的线性查找
         * 2.排序
         * 3.用hash
         **/
        if (nums.length<2) return false;
        Set<Integer> tmp = new HashSet<>();
        for (int i =0;i<nums.length;i++){
            if (tmp.contains(nums[i])) return true;
            tmp.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(1^2^3);
    }
}
