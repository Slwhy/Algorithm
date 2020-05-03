package leetcode.weeklyContest;

/**
 * @author: slwhy
 * @date: 2020/5/3
 * @description: 5401. 是否所有 1 都至少相隔 k 个元素
 */
public class KLengthApart {
    public boolean kLengthApart(int[] nums, int k) {

        int count = 0;
        int start;

        for (start = 0; start < nums.length; start++) {
            if (nums[start] == 1) break;
        }

        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (count < k) return false;
                count = 0;
            } else count++;
        }
        return true;
    }
}
