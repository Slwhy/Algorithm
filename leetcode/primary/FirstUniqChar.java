package leetcode.primary;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/3/10
 * @description: 字符串中的第一个唯一字符
 */
public class FirstUniqChar {


    public int firstUniqChar2(String s) {
        /**
         * @Author slwhy
         * @Date 2020/3/11
         * @Param [s]
         * @return int
         * @Description 两次遍历，优化的话，可以考虑将用数组统计字符出现次数，以此替代HashMap
         **/
        HashMap<Character, Integer> chs = new HashMap<>();
        char[] array = s.toCharArray();
        for (char ch : array) {
            if (chs.keySet().contains(ch)) {
                chs.replace(ch, chs.get(ch) + 1);
            } else chs.put(ch, 1);
        }
        for (int i = 0; i < array.length; i++) {
            if (chs.get(array[i]) == 1) return i;
        }
        return -1;
    }
}
