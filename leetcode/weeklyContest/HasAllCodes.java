package leetcode.weeklyContest;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: slwhy
 * @date: 2020/5/30
 * @description: 5409. 检查一个字符串是否包含所有长度为 K 的二进制子串
 */
public class HasAllCodes {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == Math.pow(2, k);
    }

    public static void main(String[] args) {
        System.out.println("01234".substring(0,3));
    }
}
