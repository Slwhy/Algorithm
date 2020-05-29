package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/5/26
 * @description: 287. 寻找重复数
 */
public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int left = 1;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int count = 0;
            for (int n : nums) {
                if (n <= mid) count++;
            }
            if (count < mid) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public int findDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) return nums[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //[1,3,4,2,1]
//        System.out.println(8>>>1);
//        System.out.println(8>>1);
        FindDuplicate findDuplicate = new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{1,3,4,2,1}));

    }
}
