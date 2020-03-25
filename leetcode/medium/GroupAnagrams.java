package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
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
        HashMap<String, List<String>> map1 = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            String tmpString = String.valueOf(tmp);
            if (map1.keySet().contains(tmpString)) {
                map1.get(tmpString).add(strs[i]);
            } else {
                List<String> item = new ArrayList<>();
                item.add(strs[i]);
                map1.put(tmpString, item);
                res.add(item);//这里传入的是对象的地址,map中的修改了,res里面的也是一样的
            }
        }
//        for (List<String> item : map1.values()) {
//            res.add(item);
//        }
        return res;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c'};
        System.out.println(chars.toString());
//        GroupAnagrams groupAnagrams = new GroupAnagrams();
//        groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

}
