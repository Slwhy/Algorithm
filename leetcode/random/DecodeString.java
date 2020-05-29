package leetcode.random;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/5/28
 * @description: 394. 字符串解码
 */
public class DecodeString {

    public String decodeString1(String s) {
        /**
         * @Author slwhy
         * @Date 2020/5/29
         * @Param [s]
         * @return java.lang.String
         * @Description leetcode 上的代码
         **/
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }


    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        StringBuilder item = new StringBuilder();
        StringBuilder num = new StringBuilder();
        int k;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ']') {
                while (!stack.peek().equals('[')) {
                    tmp.insert(0, stack.pop());
                }
                stack.pop();

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num.insert(0, stack.pop());
                }
                k = Integer.valueOf(num.toString());
                num.delete(0, num.length());
                for (int j = 0; j < k; j++) {
                    item.append(tmp);
                }
                if (stack.isEmpty()) {
                    res.append(item);
                } else {
                    for (Character c : item.toString().toCharArray()) {
                        stack.push(c);
                    }
                }
                tmp.delete(0, tmp.length());
                item.delete(0, item.length());
            } else if (!stack.isEmpty() || Character.isDigit(chars[i]) || chars[i] == '[') {
                stack.push(chars[i]);
            } else res.append(chars[i]);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(Integer.valueOf('2'));
        DecodeString decodeString = new DecodeString();

        System.out.println(decodeString.decodeString("100[leetcode]"));
    }

}
