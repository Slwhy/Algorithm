package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/8
 * @description: 移动零
 */
public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/9
         * @Param [nums]
         * @return void
         * @Description 一次遍历，参考快排思想
         **/
        if (nums.length < 1) return;
        int j = 0;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/9
         * @Param [nums]
         * @return void
         * @Description 两次遍历
         * https://leetcode-cn.com/problems/move-zeroes/solution/dong-hua-yan-shi-283yi-dong-ling-by-wang_ni_ma/
         **/
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int count = 0;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count++;
        }
        for (int time = 0; time < count; time++) {
            for (int i = 0; i < nums.length - time - 1; i++) {
                if (nums[i] == 0) {
                    tmp = nums[i + 1];
                    nums[i + 1] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2};
        moveZeroes(array);
    }
}
