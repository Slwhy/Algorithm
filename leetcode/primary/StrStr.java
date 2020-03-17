package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/16
 * @description: 实现 strStr()
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        char[] hayschars = haystack.toCharArray();
        char[] needlechars = needle.toCharArray();
        int tmp;
        int j;
        for (int i = 0; i < hayschars.length; i++) {
            tmp = i;
            j = 0;
            while (tmp < hayschars.length && j < needlechars.length && hayschars[tmp] == needlechars[j]) {
                tmp++;
                j++;
            }
            if (j == needlechars.length) return i;
        }
        return -1;
    }
}
