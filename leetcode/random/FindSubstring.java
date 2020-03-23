package leetcode.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2019/11/19
 * @description: num 30
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        //leetcode 上的解法
        //时间复杂度不是很优秀
        ArrayList res = new ArrayList();
        if (s.length() < 1 || words.length < 1) return res;
        int wordNum = words.length;
        int wordLent = words[0].length();
        int total = wordNum * wordLent;
        HashMap<String, Integer> word = new HashMap<String, Integer>();
        for (int i = 0; i < wordNum; i++) {
            if (word.keySet().contains(words[i])) word.put(words[i], word.get(words[i]) + 1);
            else word.put(words[i], 1);
        }
        for (int i = 0; i <= s.length() - total; i++) {
            HashMap<String, Integer> target = new HashMap<String, Integer>();
            for (int j = i; j < i + total; j = j + wordLent) {
                if (target.keySet().contains(s.substring(j, j + wordLent)))
                    target.put(s.substring(j, j + wordLent), target.get(s.substring(j, j + wordLent)) + 1);
                else target.put(s.substring(j, j + wordLent), 1);
            }
            if (target.equals(word)) res.add(i);
        }
        return res;
    }
}
