package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/7
 * @description: 旋转数组
 */
public class Rotate {

    public static void rotate(int[] nums, int k) {
        /**
         * @Author slwhy
         * @Date 2020/3/7
         * @Param [nums, k]
         * @return void
         * @Description 每次移动k个位置，不过当 nums.length % k == 0 时，
         * 循环一轮无法遍历到所有的元素，所以设置一个count 变量，再进行一次循环，保证所有元素均能替换一次
         **/
        if (nums.length > 0 && k > 0) {
            int tmp;
            int count = 0;
            int pre;
            k = k % nums.length;
            int curr;
            for (int start = nums.length - 1; count < nums.length; start--) {
                curr = start;
                tmp = nums[curr];
                pre = curr;
                curr = (curr - k + nums.length) % nums.length;
                while (curr != start && count < nums.length) {
                    nums[pre] = nums[curr];
                    pre = curr;
                    curr = (curr - k + nums.length) % nums.length;
                    count++;
                }
                nums[pre] = tmp;
                count++;
            }

        }
    }

    public void rotate1(int[] nums, int k) {
        /**
         * @Author slwhy
         * @Date 2020/3/7
         * @Param [nums, k]
         * @return void
         * @Description 暴力双重循环，每次整个数组向右移动一位，循环k次
         **/
        if (nums.length > 0 && k > 0) {
            int tmp;
            for (int i = 1; i <= k; i++) {
                tmp = nums[nums.length - 1];
                for (int j = nums.length - 1; j > 0; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[0] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(array, 3);
    }
}
