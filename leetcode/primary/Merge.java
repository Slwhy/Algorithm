package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/19
 * @description: 88. 合并两个有序数组
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int curr = n + m - 1;
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) nums1[curr--] = nums1[m--];
            else nums1[curr--] = nums2[n--];
        }
        while (n >= 0) nums1[curr--] = nums2[n--];
    }
}
