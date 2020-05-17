package leetcode.weeklyContest;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: slwhy
 * @date: 2020/5/17
 * @description: 5413. 重新排列句子中的单词
 */
public class ArrangeWords {

    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        StringBuilder res = new StringBuilder();
        if (text.length() >= 1 && !words[0].equals(" ")) {
            String frist = words[0].substring(0, 1);
            frist = frist.toLowerCase();
            words[0] = frist + words[0].substring(1);
            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

            frist = words[0].substring(0, 1);
            frist = frist.toUpperCase();
            words[0] = frist + words[0].substring(1);

            for (String s : words) {
                res.append(s);
                res.append(" ");
            }
            res.delete(res.length() - 1, res.length());
        }
        return res.toString();

    }

    public static void main(String[] args) {
        ArrangeWords arrangeWords = new ArrangeWords();
        System.out.println(arrangeWords.arrangeWords("Leetcode is cool"));
    }

}
