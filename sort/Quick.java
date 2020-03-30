package sort;

/**
 * @author: slwhy
 * @date: 2020/3/31
 * @description: 快速排序
 */
public class Quick {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        /**
         * @Author slwhy
         * @Date 2020/3/31
         * @Param [nums, left, right]
         * @return void
         * @Description 手写快速排序
         **/
        if (left < right) {
            int mid = partion(nums, left, right);
            quickSort(nums, left, mid - 1);
            quickSort(nums, mid + 1, right);
        }
    }

    public int partion(int[] nums, int left, int right) {
        /**
         * @Author slwhy
         * @Date 2020/3/31
         * @Param [nums, left, right]
         * @return int
         * @Description 为基准元素寻找位置, 每次选择nums[left] 作为基准元素
         **/
        int tmp = nums[left];
        while (left < right) {
            while (right > left && nums[right] >= tmp) right--;
            nums[left] = nums[right];
            nums[right] = tmp;
            while (left < right && nums[left] <= tmp) left++;
            nums[right] = nums[left];
            nums[left] = tmp;
        }
        return left;
    }
}
