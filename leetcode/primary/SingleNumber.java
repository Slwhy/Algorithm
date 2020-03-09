package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/7
 * @description: 只出现一次的数字
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/7
         * @Param [nums]
         * @return int
         * @Description 利用异或的特点
         **/
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp = tmp ^ nums[i];
        }
        return tmp;
    }
}
