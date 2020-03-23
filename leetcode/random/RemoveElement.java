package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/10/24
 * @description: num 27
 */
public class RemoveElement {
    public static int removeElement2(int[] nums, int val) {
        //leetcode 的解法
        int count = 0;
        for (int n : nums) {
            if (n != val) {
                nums[count++] = n;
            }
        }
        return count;
    }

    public static int removeElement(int[] nums, int val) {
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            if (nums[head] == val) nums[head] = nums[tail--];
            else head++;

        }
        return tail + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(array, 2));
    }
}
