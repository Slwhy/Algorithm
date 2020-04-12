package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/10
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = searchLeft(nums, target, 0, nums.length - 1);
        res[1] = searchRight(nums, target, 0, nums.length - 1);
        return res;
    }

    public int searchLeft(int[] nums, int target, int left, int right) {
        if (left >= 0 && left <= right && right < nums.length) {
            if (left == right - 1 || left == right) {
                if (nums[left] == target) return left;
                else if (nums[right] == target) return right;
                else return -1;
            }
            int mid = (left + right) / 2;
            if (nums[mid] >= target) return searchLeft(nums, target, left, mid);
            else return searchLeft(nums, target, mid + 1, right);
        } else return -1;

    }

    public int searchRight(int[] nums, int target, int left, int right) {
        if (left >= 0 && left <= right && right < nums.length) {
            if (left == right - 1 || left == right) {
                if (nums[right] == target) return right;
                else if (nums[left] == target) return left;
                else return -1;
            }

            int mid = (left + right) / 2;
            if (nums[mid] > target) return searchRight(nums, target, left, mid - 1);
            else return searchRight(nums, target, mid, right);
        } else return -1;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
    }
}
