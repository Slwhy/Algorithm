package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 461. 汉明距离
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int tmp = x ^ y;
        int count = 0;
        while (tmp != 0) {
            tmp = tmp & (tmp - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(1<<2);
    }
}
