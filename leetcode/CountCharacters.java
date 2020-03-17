package leetcode;

import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/17
 * @description: 1160. 拼写单词
 */
public class CountCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] charArray = new int[26];
        int res = 0;
        boolean isIn;
        char[] chs = chars.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            charArray[chs[i] - 'a'] += 1;
        }
        for (String s : words) {
            int[] tmp = Arrays.copyOf(charArray, charArray.length);
            isIn = true;
            char[] chsTmp = s.toCharArray();
            for (int i = 0; i < chsTmp.length; i++) {
                tmp[chsTmp[i] - 'a'] -= 1;
                if (tmp[chsTmp[i] - 'a'] < 0) {
                    isIn = false;
                    break;
                }
            }
            if (isIn) res = res + s.length();
        }
        return res;
    }
}
