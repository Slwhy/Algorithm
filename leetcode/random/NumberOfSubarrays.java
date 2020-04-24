package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/21
 * @description: 1248. 统计「优美子数组」
 */
public class NumberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int oddCount = 0;
        int rightBefo = 0;
        int res = 0;
        while (right < nums.length) {
            if (nums[right++] % 2 == 1) oddCount++;
            if (oddCount == k) {
                rightBefo = right;
                while (right < nums.length && nums[right] % 2 == 0) right++;
                int leftEvent = 0;
                while (left <= right && nums[left] % 2 == 0) {
                    left++;
                    leftEvent++;
                }
                res = res + (right - rightBefo + 1) * (leftEvent + 1);
                left++;
                oddCount--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSubarrays numberOfSubarrays = new NumberOfSubarrays();
        System.out.println(numberOfSubarrays.numberOfSubarrays(new int[]{2044, 96397, 50143}, 1));
    }
}
