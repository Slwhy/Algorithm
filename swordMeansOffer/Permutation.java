package swordMeansOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: slwhy
 * @description: 输入一个字符串, 按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 * @date: 2019/6/16
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        /**
         * @Author slwhy
         * @Date 2019/9/24
         * @Param [str]
         * @return java.util.ArrayList<java.lang.String>
         * @Description 牛客上的解法，基于回溯法
         * https://www.nowcoder.com/questionTerminal/fe6b651b66ae47d7acce78ffdd9a96c7?f=discussion
         **/
        List<String> res = new ArrayList<>();
        if (str != null && str.length() > 0) {
            PermutationHelper(str.toCharArray(), 0, res);
            Collections.sort(res);
        }
        return (ArrayList) res;
    }

    public void PermutationHelper(char[] cs, int i, List<String> list) {
        if (i == cs.length - 1) {
            String val = String.valueOf(cs);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i + 1, list);
                swap(cs, i, j);
            }
        }
    }

    public void swap(char[] cs, int i, int j) {
        char temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {

    }
}
