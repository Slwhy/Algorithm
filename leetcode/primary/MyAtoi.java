package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/11
 * @description: 字符串转换整数 (atoi)
 */
public class MyAtoi {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        boolean postive = true;
        boolean start = false;
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (!start && chars[i] == ' ') {
                continue;
            }
            if (!start && (chars[i] != '+' && chars[i] != '-' && !Character.isDigit(chars[i]))) return 0;
            if (start && !Character.isDigit(chars[i])) break;
            if (!start && chars[i] == '-') {
                start = true;
                postive = false;
                continue;
            }
            if (!start && chars[i]=='+'){
                start = true;
                continue;
            }
            if (Character.isDigit(chars[i])) {
                if (postive && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && chars[i] - '0' > 7)))
                    return Integer.MAX_VALUE;
                if (!postive && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && chars[i] - '0' > 8)))
                    return Integer.MIN_VALUE;
                start = true;
                res = res * 10 + chars[i] - '0';
            }
        }
        if (postive) return res;
        else return -1 * res;
    }

    public static void main(String[] args) {
        MyAtoi atoi = new MyAtoi();
        atoi.myAtoi("42");
    }
}
