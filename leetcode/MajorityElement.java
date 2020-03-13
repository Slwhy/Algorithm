package leetcode;

import java.util.HashMap;

/**
 * @author: slwhy
 * @date: 2020/3/13
 * @description: 169. 多数元素
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count.containsKey(nums[i])) {
                count.put(nums[i], count.get(nums[i]) + 1);
            } else count.put(nums[i], 1);
            if (max<count.get(nums[i])){
                max=count.get(nums[i]);
                res = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
