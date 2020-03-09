package leetcode;

/**
 * @author: slwhy
 * @date: 2019/11/23
 * @description: num 33
 */
public class Search {
    public static int search(int[] nums, int target) {
        return searchCore(nums, target, 0, nums.length - 1);
    }

    public static int searchCore(int[] nums, int target, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;
        if (nums[mid] == target) return mid;
        if ((nums[start] < nums[end] && nums[mid] > target) ||
                ((nums[start] > nums[end] && nums[mid] < nums[end]) && ((nums[mid] > target) || (nums[mid] < target && nums[end] < target))) ||
                ((nums[start] > nums[end] && nums[mid] > nums[end]) && (nums[mid] > target && nums[end] < target)))
            return searchCore(nums, target, start, mid - 1);
        else return searchCore(nums, target, mid + 1, end);

    }

    public static void main(String[] args) {
        int[] array = new int[]{4,5,6,7,8,1,2,3};
        System.out.println(search(array, 8));
    }
}
