package leetcode.primary;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @date: 2020/3/10
 * @description: 整数反转
 */
public class Reverse {

    public int reverse2(int x) {
        /**
         * @Author slwhy
         * @Date 2020/3/10
         * @Param [x]
         * @return int
         * @Description leetcode 上面的，处理溢出时，非常巧妙
         **/
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;

    }

    public int reverse(int x) {
        ArrayList<Integer> nums = new ArrayList<>();
        if (x == 0) return 0;
        while (x != 0) {
            nums.add(x % 10);
            x = x / 10;
        }
        int res = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            res = res * 10 + nums.get(i);
        }

        if ((nums.size() == 10) && ((Integer.MAX_VALUE / 10 < res) || (Integer.MAX_VALUE / 10 == res && nums.get(nums.size() - 1) > 7) || (Integer.MIN_VALUE / 10 > res) || (Integer.MIN_VALUE / 10 == res && nums.get(nums.size() - 1) < -8))) {
            return 0;
        } else return res * 10 + nums.get(nums.size() - 1);
    }

    public static void main(String[] args) {
        Reverse res = new Reverse();
        System.out.println(res.reverse(1534236469));
    }
}
