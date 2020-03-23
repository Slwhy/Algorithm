package leetcode.random;

import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2019/11/21
 * @description: num 38
 */
public class CountAndSay {

    public static String countAndSay3(int n) {
        // leetcode 上的解法,其实和方法二差别不大，不过用了StringBuilder进行优化，效果更为优越
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for (int i = 2; i <= n; i++) {
            //遍历前一个字符串
            String currentStr = new String(ans);
            ans.delete(0, ans.length());
            int num = 0;
            char currentChar = currentStr.charAt(0);
            for (char c : currentStr.toCharArray()) {
                if (c == currentChar) {
                    num++;
                } else {
                    ans.append((char) ('0' + num));
                    ans.append(currentChar);
                    currentChar = c;
                    num = 1;
                }
            }
            ans.append((char) ('0' + num));
            ans.append(currentChar);

        }

        return ans.toString();
    }

    public static String countAndSay2(int n) {
        //对方法1进行优化,省略了队列
        if (n == 1) return "1";
        String tmp = "1";
        String res = "";
        int count;
        for (int i = 1; i < n; i++) {
            res = "";
            for (int j = 0; j < tmp.length(); j++) {
                count = 1;
                while (j < tmp.length() - 1 && tmp.charAt(j) == tmp.charAt(j + 1)) {
                    count++;
                    j++;
                }
                res = res + count + tmp.charAt(j);
            }
            tmp = res;

        }
        return res;
    }

    public static String countAndSay(int n) {
        //暴力
        if (n == 1) return "1";
        String tmp = "1";
        String res = "";
        int count;
        Stack stack1 = new Stack<Character>();
        for (int i = 1; i < n; i++) {
            res = "";
            for (int j = 0; j < tmp.length(); ) {
                count = 0;
                while (j < tmp.length() && (stack1.isEmpty() || stack1.peek().equals(tmp.charAt(j)))) {
                    stack1.push(tmp.charAt(j++));
                    count++;
                }
                res = res + count + stack1.peek();
                stack1.clear();
            }
            tmp = res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay3(13));
        System.out.println((char) ('0' + 2));
    }
}
