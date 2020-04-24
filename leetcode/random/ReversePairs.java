package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/24
 * @description: 面试题51. 数组中的逆序对
 */
public class ReversePairs {
    public int reversePairs(int[] nums) {
        int[] copy = new int[nums.length];
        int res = merge(nums, copy, 0, nums.length - 1);
        return res;
    }

    public int merge(int[] nums, int[] copy, int left, int right) {
        /**
         * @Author slwhy
         * @Date 2020/4/24
         * @Param [nums, copy, left, right]
         * @return int
         * @Description 归并解法
         **/
        if (left >= 0 && left < right && right < nums.length) {
            int mid = (left + right) / 2;
            int leftCount = merge(nums, copy, left, mid);
            int rightCount = merge(nums, copy, mid + 1, right);
            int currCount = 0;
            int indexLeft = left;
            int indexRight = mid + 1;
            int i = left;
            for (; i <= right && indexLeft <= mid && indexRight <= right; ) {
                //nums[indexLeft] <= nums[indexRight],这里要用<=,这里应该用稳定排序,用<=才是稳定排序
                if (nums[indexLeft] <= nums[indexRight]) {
                    if (i - indexLeft > 0) currCount += (i - indexLeft);
                    copy[i++] = nums[indexLeft++];
                } else copy[i++] = nums[indexRight++];
            }
            while (indexLeft <= mid) {
                if (i - indexLeft > 0) currCount += (i - indexLeft);
                copy[i++] = nums[indexLeft++];
            }
            while (indexRight <= right) copy[i++] = nums[indexRight++];
            for (int index = left; index <= right; index++) {
                nums[index] = copy[index];
            }
            return currCount + leftCount + rightCount;
        } else return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 2, 3, 1};
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(array));
        for (int i : array) {
            System.out.println(i);
        }
    }
}
