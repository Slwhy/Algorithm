package leetcode.primary;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 204. 计数质数
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] num = new boolean[n];
        Arrays.fill(num, true);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * i; j < n; j += i) {
                num[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (num[i]) count++;
        }
        return count;
    }

    public int countPrimes1(int n) {
        if (n <= 2) return 0;
        int count = 0;
        boolean is;
        for (int i = 2; i < n; i++) {
            is = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    is = false;
                    break;
                }
            }
            if (is) count++;
        }
        return count;
    }
}
