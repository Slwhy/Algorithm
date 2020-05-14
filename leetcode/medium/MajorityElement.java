package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/5/11
 * @description: 169. 多数元素
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int curr = 0;
        for (int n : nums) {
            if (count == 0) {
                curr = n;
                count++;
            } else if (n == curr) count++;
            else count--;
        }
        return curr;
    }
}
