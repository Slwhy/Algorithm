package leetcode.primary;


import java.util.Arrays;

/**
 * @author: slwhy
 * @date: 2020/3/11
 * @description: 有效的字母异位词
 */
public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        /**
         * @Author slwhy
         * @Date 2020/3/11
         * @Param [s, t]
         * @return boolean
         * @Description leetcode上的，排序后直接对字符数组进行比较
         **/
        if (s.length() != t.length()) return false;
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] sArray = new char[26];
        char[] tArray = new char[26];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            sArray[sChars[i] - 'a'] += 1;
            tArray[tChars[i] - 'a'] += 1;
        }
        return Arrays.equals(sArray, tArray);
    }
}
