package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/18
 * @description: 11. 盛最多水的容器
 */
public class MaxArea {
    public int maxArea(int[] height) {
        /**
         * @Author slwhy
         * @Date 2020/4/18
         * @Param [height]
         * @return int
         * @Description leetcode 上的解法，双指针策略，由两端向中间逼近，每次移动高度较小的指针
         **/
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            if ((right - left) * Math.min(height[left], height[right]) > area)
                area = (right - left) * Math.min(height[left], height[right]);
            if (height[left] >= height[right]) right--;
            else left++;
        }
        return area;
    }
}
