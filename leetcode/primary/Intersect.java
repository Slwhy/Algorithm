package leetcode.primary;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/7
 * @description: 两个数组的交集 II
 */
public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        int curr1 = 0, curr2 = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> res = new ArrayList<>();
        while (curr1 < nums1.length && curr2 < nums2.length) {
            if (nums1[curr1] == nums2[curr2]) {
                res.add(nums1[curr1]);
                curr1++;
                curr2++;
            } else if (nums1[curr1] > nums2[curr2]) curr2++;
            else curr1++;
        }
        int[] array = new int[res.size()];
        int i = 0;
        for (Integer item : res) {
            array[i++] = (int) item;
        }
        return array;
    }
}
