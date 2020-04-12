package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/10
 * @description: 162. 寻找峰值
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        /**
         * @Author slwhy
         * @Date 2020/4/10
         * @Param [nums, l, r]
         * @return int
         * @Description leetcode 上的二分,
         * nums[-1] = nums[n] = -∞,而且 nums[i] ≠ nums[i+1]，所以大的一侧一定是有解的
         * 一条曲线，两端都是 -∞，如果num[mid]>num[mid+1] 则在 左侧一定有解，画图很容易理解
         **/
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }

    public int findPeakElement2(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/4/10
         * @Param [nums]
         * @return int
         * @Description 自己写的二分
         **/
        if (nums.length < 2) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        return help(nums, 0, nums.length - 1);
    }

    public int help(int[] nums, int start, int end) {
        if (start >= 0 && start <= end && end < nums.length) {
            int mid = (start + end) / 2;
            if (mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            else {
                int left = help(nums, start, mid - 1);
                if (left != -1) return left;
                else return help(nums, mid + 1, end);
            }
        } else return -1;
    }

    public int findPeakElement1(int[] nums) {
        if (nums.length < 2) return 0;
        if (nums[0] > nums[1]) return 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{3, 4, 3, 2, 1};
        FindPeakElement findPeakElement = new FindPeakElement();
        System.out.println(findPeakElement.findPeakElement(array));
    }
}
