package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/6/4
 * @description: 238. 除自身以外数组的乘积
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/6/4
         * @Param [nums]
         * @return int[]
         * @Description leetcode 上的思路,将前缀存放到结果数组内，后缀用一个数累乘
         **/
        int[] res = new int[nums.length];
        int suffix = 1;
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            suffix *= nums[i + 1];
            res[i] *= suffix;
        }
        return res;

    }

    public int[] productExceptSelf1(int[] nums) {
        int[] pre = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];
        pre[0] = 1;
        suffix[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
            suffix[nums.length - i - 1] = suffix[nums.length - i] * nums[nums.length - i];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = pre[i] * suffix[i];
        }
        return res;
    }

    public static void main(String[] args) {
        ProductExceptSelf productExceptSelf = new ProductExceptSelf();

    }
}
