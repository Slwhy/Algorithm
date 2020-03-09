package leetcode;

/**
 * @author: slwhy
 * @date: 2019/11/14
 * @description: num 35
 */
public class SearchInsert {
    public static int searchInsert(int[] nums, int target) {
        //二分
        return searchInsertCore(nums, target, 0, nums.length - 1);
    }

    public static int searchInsertCore(int[] nums, int target, int start, int end) {
        if (start < end) {
            if (nums[(start + end) / 2] == target) return (start + end) / 2;
            else if (nums[(start + end) / 2] < target)
                return searchInsertCore(nums, target, (start + end) / 2 + 1, end);
            else return searchInsertCore(nums, target, start, (start + end) / 2 - 1);
        } else {
            if (nums[start]<target) return start+1;
            else return start;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 3};
        System.out.println(searchInsert(array, 2));
    }
}
