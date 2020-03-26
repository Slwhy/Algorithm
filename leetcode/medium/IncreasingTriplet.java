package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/3/26
 * @description: 334. 递增的三元子序列
 */
public class IncreasingTriplet {

    public boolean increasingTriplet(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/3/26
         * @Param [nums]
         * @return boolean
         * @Description leetcode 上的解法
         * 这个思路其实之前想出来了,但不过有一个问题没有想通,就是
         * 如果出现 5 6 1 7 这种数据，当数据遍历到1的时候,比5小所以要替换掉,但此时 1,6 两个数的先后顺序并不符合题意
         * 那么为什么这个是可行的呢？可以这样思考当1替换后,继续向后遍历，num[i] 有三种情况
         * 1.比frist 小，这个没啥说的继续保持之前的策略，替换掉frist
         * 2.比second 小，替换掉second，这时 frist 和second 前后顺序就又符合要求了
         * 3.比second 大，有疑问的是这种情况，这时7比6大，所以应该返回true，但是1 6 7 这个序列并不符合题意
         * 因为1 在6 的后面，但其实符合题意的序列是 5 6 7，在 1 替换 frist之前，second（6）是比frist（5）大的，
         * 当 7>6 的时候，那么 7>5 ，而此时 5 6 顺序是对的，所以 5 6 7 这个序列符合题意要求
         **/
        if (nums.length < 3) return false;
        int frist = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= frist) {
                frist = nums[i];
            } else if (nums[i] <= second) {
                second = nums[i];
            } else return true;
        }
        return false;
    }
}
