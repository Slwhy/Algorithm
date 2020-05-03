package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: slwhy
 * @date: 2020/4/28
 * @description: 202. 快乐数
 */
public class IsHappy {
    public boolean isHappy(int n) {
        /**
         * @Author slwhy
         * @Date 2020/4/28
         * @Param [n]
         * @return boolean
         * @Description 模拟
         **/
        Set<Integer> set = new HashSet<>();
        while (true) {
            if (set.contains(n)) return false;
            set.add(n);
            int tmp = 0;
            while (n > 0) {
                tmp += (int) Math.pow(n % 10, 2);
                n = n / 10;
            }
            if (tmp == 1) return true;
            n = tmp;
        }
    }
}
