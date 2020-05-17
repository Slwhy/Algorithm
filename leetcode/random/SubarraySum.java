package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/5/15
 * @description: 560. 和为K的子数组
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        /**
         * @Author slwhy
         * @Date 2020/5/15
         * @Param [nums, k]
         * @return int
         * @Description 暴力
         **/
        int sum;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }

        return count;
    }

    //[28,54,7,-70,22,65,-6]  100
    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{28, 54, 7, -70, 22, 65, -6}, 100));
    }

}
