package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/4/10
 * @description: 151. 翻转字符串里的单词
 */
public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            word.delete(0, word.length());
            while (i < chars.length && chars[i] != ' ') word.append(chars[i++]);
            res.insert(0, word);
            res.insert(0, ' ');
        }
        if (res.length() > 1) res.delete(0, 1);
        return res.toString();
    }

    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        res.append("abc");
        res.insert(0, "nihao");
        System.out.println(res.toString());
    }
}
