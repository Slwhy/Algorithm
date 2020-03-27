package leetcode.random;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @date: 2020/3/27
 * @description: 914. 卡牌分组
 */
public class HasGroupsSizeX {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) return false;
        int[] nums = new int[10000];
        for (int item : deck) {
            nums[item] += 1;
        }
//        ArrayList<Integer> tmp = new ArrayList<Integer>();
//        for (int n : nums) {
//            if (n > 0) tmp.add(n);
//        }
//        if (tmp.size() < 1) return false;
//        int gcd = tmp.get(0);
        int gcd = nums[deck[0]];
        for (int item : nums) {
            if (item > 0) {
                gcd = gcd(gcd, item);
            }
            if (gcd < 2) return false;
        }
        return true;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        HasGroupsSizeX group = new HasGroupsSizeX();
        System.out.println(group.hasGroupsSizeX(new int[]{1, 1, 1, 1, 1, 0, 0, 0}));
    }
}
