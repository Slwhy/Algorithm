package leetcode.random;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: slwhy
 * @date: 2020/5/15
 * @description: 560. 和为K的子数组
 */
public class SubarraySum {

    public int subarraySum(int[] nums, int k) {
        /**
         * @Author slwhy
         * @Date 2020/5/18
         * @Param [nums, k]
         * @return int
         * @Description leetcode上的，对方法2进行优化
         **/
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;

            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }

            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;


    }

    public int subarraySum2(int[] nums, int k) {
        /**
         * @Author slwhy
         * @Date 2020/5/18
         * @Param [nums, k]
         * @return int
         * @Description leetcode 上的解法，前缀和
         **/
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) {
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
