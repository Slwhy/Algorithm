package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/28
 * @description: 面试题56 - I. 数组中数字出现的次数
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int flag = nums[0];
        int num1 = 0;
        int num2 = 0;
        for (int i = 1; i < nums.length; i++) {
            flag = flag ^ nums[i];
        }
        int tmp = 1;
        while (0 == (flag & tmp)) {
            tmp = tmp << 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if ((tmp & nums[i]) == 0) {
                num1 = num1 ^ nums[i];
            } else num2 = num2 ^ nums[i];
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        System.out.println(3 << 1);
    }
}
