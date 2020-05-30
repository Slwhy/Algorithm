package leetcode.random;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: slwhy
 * @date: 2020/5/30
 * @description: 84. 柱状图中最大的矩形
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        /**
         * @Author slwhy
         * @Date 2020/5/30
         * @Param [heights]
         * @return int
         * @Description leetcoode 上的解法，单调栈
         **/
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);

        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 对栈中柱体来说，栈中的下一个柱体就是其「左边第一个小于自身的柱体」；
            // 若当前柱体 i 的高度小于栈顶柱体的高度，说明 i 是栈顶柱体的「右边第一个小于栈顶柱体的柱体」。
            // 因此以栈顶柱体为高的矩形的左右宽度边界就确定了，可以计算面积🌶️ ～
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int h = tmp[stack.pop()];
                area = Math.max(area, (i - stack.peek() - 1) * h);
            }
            stack.push(i);
        }

        return area;
    }

    public int largestRectangleArea1(int[] heights) {
        /**
         * @Author slwhy
         * @Date 2020/5/30
         * @Param [heights]
         * @return int
         * @Description 暴力解
         **/
        int max = 0;
        int heigh = 0;
        for (int i = 0; i < heights.length; i++) {
            heigh = heights[i];
            for (int j = i; j < heights.length; j++) {
                heigh = Math.min(heights[j], heigh);
                max = Math.max(max, heigh * (j - i + 1));
            }
        }

        return max;
    }

}
