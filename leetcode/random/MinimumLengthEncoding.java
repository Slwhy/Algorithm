package leetcode.random;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: slwhy
 * @date: 2020/3/28
 * @description: 820. 单词的压缩编码
 */

class TrieNode1 {
    /**
     * @Author slwhy
     * @Date 2020/3/30
     * @Param
     * @return
     * @Description 字典树的定义
     **/

    public char val;
    public TrieNode1[] children = new TrieNode1[26];

    public TrieNode1() {

    }

    public TrieNode1(char ch) {
        val = ch;
    }


}

public class MinimumLengthEncoding {

    TrieNode1 root = new TrieNode1();

    public int minimumLengthEncoding(String[] words) {
        /**
         * @Author slwhy
         * @Date 2020/3/30
         * @Param [words]
         * @return int
         * @Description leetcode上的解法，基于字典树
         **/
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            res += insert(words[i]);
        }
        return res;
    }

    public int insert(String s) {
        char[] chars = s.toCharArray();
        TrieNode1 curr = root;
        boolean isNew = false;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (curr.children[chars[i] - 'a'] == null) {
                isNew = true;
                curr.children[chars[i] - 'a'] = new TrieNode1(chars[i]);
            }
            curr = curr.children[chars[i] - 'a'];
        }
        return isNew ? s.length() + 1 : 0;

    }

    public int minimumLengthEncoding1(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        StringBuilder compr = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i == 0) {
                compr.append(words[i]);
                compr.append('#');
                continue;
            }
            StringBuilder item = new StringBuilder();
            item.append(words[i]);
            item.append('#');
            if (compr.indexOf(item.toString()) != -1) ;
            else compr.append(words[i]).append('#');

        }
        return compr.length();
    }

    public static void main(String[] args) {
        MinimumLengthEncoding encod = new MinimumLengthEncoding();
        String[] tmp = new String[]{"me", "time"};
        StringBuilder tmp2 = new StringBuilder();
        tmp2.append("abcdefg#");
        System.out.println(encod.minimumLengthEncoding(tmp));
    }
}
