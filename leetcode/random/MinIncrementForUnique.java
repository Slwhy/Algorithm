package leetcode.random;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/22
 * @description: 945. 使数组唯一的最小增量
 */
public class MinIncrementForUnique {

    public int minIncrementForUnique(int[] A) {
        /**
         * @Author slwhy
         * @Date 2020/3/22
         * @Param [A]
         * @return int
         * @Description leetcode 上的解法 线性探测(含路径压缩)
         **/
        int[] nums = new int[80000];
        Arrays.fill(nums, -1);
        int count = 0;
        for (int n : A) {
            int tmp = findPath(nums, n);
            count += tmp - n;
        }
        return count;

    }

    public int findPath(int[] nums, int n) {
        if (nums[n] == -1) {
            nums[n] = n;
            return n;
        }
        int tmp = nums[n];
        tmp = findPath(nums, tmp + 1);
        //路径压缩,nums[n] 记录了最后寻找到的空位，当下一次n进来的时候,直接访问 tmp+1 位置即可
        nums[n] = tmp;
        return tmp;
    }

    public int minIncrementForUnique2(int[] A) {
        /**
         * @Author slwhy
         * @Date 2020/3/22
         * @Param [A]
         * @return int
         * @Description leetcode 上的计数统计法
         * 先用一个数组统计出所有数据出现的次数,而后遍历这个数组,将出现次数超过1的那部分数据往右move
         * 并记录下move 的次数,最后记得要考虑max元素的情况(max这里可能囤积了很多前面move过来的，以及本身重复的)
         **/
        int res = 0;
        int[] num = new int[40000];
        int max = 0;
        for (int n : A) {
            num[n] += 1;
            max = max > n ? max : n;
        }
        for (int i = 0; i < max; i++) {
            if (num[i] > 1) {
                num[i + 1] += num[i] - 1;
                res += num[i] - 1;
            }
        }
        res += (num[max] - 1) * num[max] / 2;
        return res;
    }

    public int minIncrementForUnique1(int[] A) {
        /**
         * @Author slwhy
         * @Date 2020/3/22
         * @Param [A]
         * @return int
         * @Description 将数组排序后，开始遍历，如果A[i]>A[i-1] 说明没有重复的继续，
         * 如果A[i]<A[i-1]，将A[i]=A[i-1]+1(这是避免重复且move代价最小的手段),并记录下move的代价
         **/
        int count = 0;
        int tmp;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) continue;
            tmp = A[i];
            A[i] = A[i - 1] + 1;
            count = count + (A[i - 1] + 1 - tmp);
        }
        return count;
    }
}
