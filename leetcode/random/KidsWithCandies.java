package leetcode.random;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/6/1
 * @description: 1431. 拥有最多糖果的孩子
 */
public class KidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(candies[i], max);
        }
        for (int c : candies) {
            if (c+extraCandies>=max) res.add(true);
            else res.add(false);
        }
        return res;
    }
}
