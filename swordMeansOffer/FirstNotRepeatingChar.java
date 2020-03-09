package swordMeansOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: slwhy
 * @description: 在一个字符串(0 < = 字符串长度 < = 10000 ，
 *全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 * @date: 2019/8/27
 */
public class FirstNotRepeatingChar {
    public static int firstNotRepeatingChar(String str) {
        /**
         * @description 利用一个map统计所有字母出现频率，而后遍历一遍，找到第一个频率为1的字符
         * @author slwhy
         * @date 2019/8/27
         * @param str
         * @return int
         */

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char current;
        for (int i = 0; i < str.length(); i++) {
            current = str.charAt(i);
            if (map.containsKey(current)) {
                map.put(current, map.get(current) + 1);
            } else {
                map.put(current, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            current = str.charAt(i);
            if (map.get(current) == 1) {
                return i;
            }
        }
        return -1;
    }
}
