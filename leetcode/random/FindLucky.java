package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/3/29
 * @description: 5368. 找出数组中的幸运数
 */
public class FindLucky {
    public int findLucky(int[] arr) {
        int[] nums = new int[501];
        for (int i = 0; i < arr.length; i++) {
            nums[arr[i]] += 1;
        }
        for (int i = 500; i > 0; i--) {
            if (nums[i] == i) return i;
        }
        return -1;
    }
}
