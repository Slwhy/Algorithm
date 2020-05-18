package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/5/18
 * @description: 152. 乘积最大子数组
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/5/18
         * @Param [nums]
         * @return int
         * @Description leetcode 上的dp解法，没有想到同时保存最大值和最小值
         **/
        int max = nums[0];
        int imax = nums[0];
        int imin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);

        }

        return max;
    }

    public static void main(String[] args) {
        //[2,-5,-2,-4,3]
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{2, -5, -2, -4, 3}));
    }

}
