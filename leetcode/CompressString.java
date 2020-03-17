package leetcode;

/**
 * @author: slwhy
 * @date: 2020/3/16
 * @description: 面试题 01.06. 字符串压缩
 */
public class CompressString {
    public String compressString(String S) {
        StringBuilder res = new StringBuilder();
        char[] chars = S.toCharArray();
        int count;
        for (int i = 1; i < chars.length; i++) {
            count = 1;
            while (i < chars.length && chars[i] == chars[i - 1]) {
                i++;
                count++;
            }
            res.append(chars[i - 1]);
            res.append(count);
        }
        if (chars.length > 1 && chars[chars.length - 1] != chars[chars.length - 2]) {
            res.append(chars[chars.length - 1]);
            res.append(1);
        }
        if (chars.length == 1) return S;
        return res.toString().length() >= S.length() ? S : res.toString();
    }
}
