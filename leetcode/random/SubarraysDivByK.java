package leetcode.random;

import java.util.HashMap;

/**
 * @author: slwhy
 * @date: 2020/5/27
 * @description: 974. 和可被 K 整除的子数组
 */
public class SubarraysDivByK {

    public int subarraysDivByK(int[] A, int K) {
        /**
         * @Author slwhy
         * @Date 2020/5/27
         * @Param [A, K]
         * @return int
         * @Description leetcode上的代码，前缀和
         **/
        int[] map = new int[K];
        ++map[0];
        int prefix = 0, res = 0;
        for (int a : A) {
            prefix = (a + prefix) % K;
            if (prefix < 0) prefix += K;
            res += map[prefix]++;
        }
        return res;
    }

    public int subarraysDivByK1(int[] A, int K) {

        /**
         * @Author slwhy
         * @Date 2020/5/27
         * @Param [A, K]
         * @return int
         * @Description leetcode 上的代码，
         * 自己想到了前缀和，但是没想到如何优化，直接用hash 存储了所有的前缀和，超时了
         **/

        int res = 0;
        HashMap<Integer, Integer> prefix = new HashMap<>();
        prefix.put(0, 1);
        int sum = 0;
        for (int n : A) {
            sum += n;
            int num = (sum % K + K) % K;
            int count = prefix.getOrDefault(num, 0);
            res += count;
            prefix.put(num, count + 1);

        }

        return res;
    }
}
