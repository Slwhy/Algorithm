package leetcode.weeklyContest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/5/16
 * @description: //todo
 */
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) {
                    res.add(String.valueOf(j) + "/" + String.valueOf(i));
                }
            }
        }
        return res;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        SimplifiedFractions simplifiedFractions = new SimplifiedFractions();
        System.out.println(simplifiedFractions.gcd(6, 4));
    }
}
