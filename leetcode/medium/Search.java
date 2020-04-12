package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/11
 * @description: 33. 搜索旋转排序数组
 */
public class Search {
    public int search(int[] nums, int target) {
        return binary(nums, target, 0, nums.length - 1);
    }

    public int binary(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if ((nums[mid] >= nums[left] && nums[mid] >= nums[right] && (nums[mid] < target || nums[right] >= target)) ||
                    (nums[mid] < nums[left] && nums[mid] < nums[right] && nums[mid] < target && nums[right] >= target) ||
                    (nums[left] >= nums[mid] && nums[mid] >= nums[right] && nums[mid] > target) ||
                    (nums[left] <= nums[mid] && nums[mid] <= nums[right] && nums[mid] < target))
                return binary(nums, target, mid + 1, right);
            else return binary(nums, target, left, mid - 1);
        } else return -1;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{1,3};
        Search search = new Search();
        System.out.println(search.search(arr, 3));
    }
}
