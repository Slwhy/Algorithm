package leetcode.random;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: slwhy
 * @date: 2020/5/30
 * @description: 739. 每日温度
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        /**
         * @Author slwhy
         * @Date 2020/5/30
         * @Param [T]
         * @return int[]
         * @Description 单调栈, 参考84. 柱状图中最大的矩形 的思路写的
         **/
        int[] tmp = new int[T.length + 1];
        tmp[0] = Integer.MAX_VALUE;
        System.arraycopy(T, 0, tmp, 1, T.length);
        int[] res = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[stack.peek()] < tmp[i]) {
                res[stack.peek() - 1] = i - stack.poll();
            }
            stack.push(i);
        }
        return res;
    }

}
