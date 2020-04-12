package leetcode.medium;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/4/10
 * @description: 215. 数组中的第K个最大元素
 */
public class FindKthLargest {

    public int findKthLargest(int[] nums, int k) {
        /**
         * @Author slwhy
         * @Date 2020/4/10
         * @Param [nums, k]
         * @return int
         * @Description 小根堆解法
         **/
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                floating(nums, i);
            } else if (nums[i] > nums[0]) {
                swap(nums, 0, i);
                sinking(nums, k - 1);
            }
        }
        return nums[0];
    }

    public void floating(int[] array, int index) {
        int father = 0;
        while (father >= 0) {
            father = (index - 1) / 2;
            if (array[father] > array[index]) {
                swap(array, father, index);
                index = father;
            } else father = -1;
        }
    }

    public void sinking(int[] array, int end) {
        int father = 0;
        int child;
        while (father < (end + 1) / 2) {
            if (father * 2 + 2 <= end)
                child = array[father * 2 + 1] < array[father * 2 + 2] ? father * 2 + 1 : father * 2 + 2;
            else child = father * 2 + 1;
            if (array[father] > array[child]) {
                swap(array, father, child);
                father = child;
            } else break;

        }
    }

    public void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }

    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
