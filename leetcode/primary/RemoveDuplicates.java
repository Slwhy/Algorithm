package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/6
 * @description: 从排序数组中删除重复项
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/6
         * @Param [nums]
         * @return int
         * @Description 对于方法二的优化，一遍循环
         **/
        int curr = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[curr]) nums[++curr] = nums[i];
        }
        return curr + 1;
    }

    public int removeDuplicates2(int[] nums) {
        Boolean isEnd = false;
        for (int i = 1; i < nums.length; i++) {
            isEnd = true;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] > nums[i - 1]) {
                    nums[i] = nums[j];
                    isEnd = false;
                    break;
                }
            }
            if (isEnd) return i;
        }
        return nums.length;
    }
}
