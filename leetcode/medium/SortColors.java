package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/4/3
 * @description: 75. 颜色分类
 */
public class SortColors {

    public void sortColors(int[] nums) {
        int p0 = 0;
        int p2 = nums.length - 1;
        int curr = 0;
        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                tmp = nums[p0];
                nums[p0] = nums[curr];
                nums[curr++] = tmp;
                p0++;
            } else if (nums[curr] == 2) {
                tmp = nums[p2];
                nums[p2] = nums[curr];
                nums[curr] = tmp;
                p2--;
            } else curr++;
        }
    }

    public void sortColors1(int[] nums) {
        /**
         * @Author slwhy
         * @Date 2020/4/3
         * @Param [nums]
         * @return void
         * @Description 计数排序，两遍扫描
         **/
        int[] colors = new int[3];
        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < colors[0]) nums[i] = 0;
            else if (i < colors[1] + colors[0]) nums[i] = 1;
            else nums[i] = 2;
        }
    }
}
