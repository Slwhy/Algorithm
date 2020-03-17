package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/16
 * @description: 最长公共前缀
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        int lent = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            lent = Math.min(lent, strs[i].length());
        }
        if (lent < 1) return "";
        StringBuilder res = new StringBuilder();
        res.append("");
        for (int i = 0; i < lent; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].toCharArray()[i] != strs[j - 1].toCharArray()[i]) {
                    return res.toString();
                }
            }
            res.append(strs[0].toCharArray()[i]);
        }
        return res.toString();
    }
}
