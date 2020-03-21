package leetcode.primary;

import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/3/21
 * @description: 20. 有效的括号
 */
public class IsValid {
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            } else {
                if (!stack.isEmpty()){
                    Character tmp = stack.pop();
                    if (chars[i] == ')' && tmp.equals('(')) continue;
                    if (chars[i] == ']' && tmp.equals('[')) continue;
                    if (chars[i] == '}' && tmp.equals('{')) continue;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}
