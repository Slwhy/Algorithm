package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 191. 位1的个数
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
