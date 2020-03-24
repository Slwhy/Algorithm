package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/3/23
 * @description: 49. 字母异位词分组
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, List<String>> map1 = new HashMap<>();
        int flag;
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            flag = 0;
            for (int j = 0; j < chars.length; j++) {
                flag = flag + 1 << (chars[j] - 'a');
            }
            if (map1.keySet().contains(flag)) {
                map1.get(flag).add(strs[i]);
            } else {
                List<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                map1.put(flag, tmp);
            }
        }
        for (Integer key : map1.keySet()) {
            res.add(map1.get(key));
        }
        return res;
    }

}
