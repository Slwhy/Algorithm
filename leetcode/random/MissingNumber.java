package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/10/15
 * @description: num 268
 */
public class MissingNumber {

    public static int missingNumber2(int[] nums) {
        //异或求解，这个解法当时没想起来
        int lent = nums.length;
        int res = lent;
        for (int i = 0; i < lent; i++) {
            res = res ^ i;
            res = res ^ nums[i];
        }
        return res;
    }

    public static int missingNumber(int[] nums) {
        int lent = nums.length;
        int sum = (lent + 1) * lent / 2;
        for (int i = 0; i < lent; i++) {
            sum = sum - nums[i];
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 0, 1, 2};
        System.out.println(missingNumber2(array));
    }
}
