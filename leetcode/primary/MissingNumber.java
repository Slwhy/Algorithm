package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 268. 缺失数字
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = (nums.length *(nums.length + 1))/2;
        for (int i = 0; i < nums.length; i++) {
            sum = sum - nums[i];
        }
        return sum;
    }
}
