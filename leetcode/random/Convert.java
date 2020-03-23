package leetcode.random;

import java.util.Vector;

import static java.lang.Math.min;

/**
 * @author: slwhy
 * @date: 2019/10/22
 * @description: num 6
 */
public class Convert {
    public static String convert2(String s, int numRows) {
        // leetcode 上的解法，很巧妙，把z变换后的每一行都存为保存到一个StringBuilder中
        if (numRows < 2) return s;
        Vector<StringBuilder> rows = new Vector<StringBuilder>();
        for (int i = 0; i < min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        int index = 0;
        boolean goDown = false;
        for (int i = 0; i < s.length(); i++) {
            rows.get(index).append(s.charAt(i));
            if (index == 0 || index == numRows - 1) goDown = !goDown;
            index += goDown ? 1 : -1;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : rows) {
            res.append(sb);
        }
        return String.valueOf(res);

    }

    public static String convert(String s, int numRows) {
        // 要注意考虑边界情况
        //比如说，判断数组是否越界，当numRows为0
        if (s.length() < 1) return "";
        if (numRows < 2) return s;
        int col = s.length() / (2 * (numRows - 1));
        int remain = s.length() % (2 * (numRows - 1));
        char[] res = new char[s.length()];
        int index = 0;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                for (int j = 0; j < col; j++) {
                    res[index++] = s.charAt(i + j * 2 * (numRows - 1));
                }
                if (remain > i) {
                    res[index++] = s.charAt(i + col * 2 * (numRows - 1));
                }
            } else {
                for (int j = 0; j < col; j++) {
                    res[index++] = s.charAt(i + j * 2 * (numRows - 1));
                    res[index++] = s.charAt(i + (j + 1) * 2 * (numRows - 1) - 2 * i);
                }
                if (remain > i) {
                    res[index++] = s.charAt(i + col * 2 * (numRows - 1));
                }
                if (remain > (2 * (numRows - 1) - i)) {
                    res[index++] = s.charAt(i + (col + 1) * 2 * (numRows - 1) - 2 * i);
                }
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(convert2("ABCDE", 4));
        System.out.println(convert("ABCDE", 4));

    }
}
