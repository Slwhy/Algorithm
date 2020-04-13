package leetcode.weeklyContest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/4/12
 * @description: 5380. 数组中的字符串匹配
 */
public class StringMatching {
    public List<String> stringMatching(String[] words) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    res.add(words[i]);
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        StringMatching strm = new StringMatching();
        String [] arr = new String[]{"mass","as","hero","superhero"};
        List<String> res = strm.stringMatching(arr);
        for (String s:res){
            System.out.println(s);
        }
    }
}
