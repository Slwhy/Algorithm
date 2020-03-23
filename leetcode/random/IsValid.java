package leetcode.random;

import swordMeansOffer.StrToInt;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2019/10/18
 * @description: num 20
 */
public class IsValid {
    public static boolean isValid2(String s) {
        // 很多细节容易忽略，如 ((,(,等情况
        if (s.length() % 2 == 1) return false;
        Stack stack1 = new Stack();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        boolean res = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack1.push(s.charAt(i));
                res = false;
                continue;
            }
            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (!stack1.isEmpty() && stack1.pop()==(map.get(s.charAt(i)))) {
                    res = true;
                } else return false;
            }
        }
        return res;
    }

    public static boolean isValid(String s){
        Stack stack1 = new Stack();
        if (s.length() % 2 == 1) return false;
        boolean res = true;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack1.push(s.charAt(i));
                res = false;
                continue;
            }
            if (s.charAt(i) == ')') {
                if (!stack1.isEmpty() && stack1.pop().equals('(')) {
                    res = true;
                    continue;
                } else return false;
            }
            if (s.charAt(i) == ']') {
                if (!stack1.isEmpty() && stack1.pop().equals('[')) {
                    res = true;
                    continue;
                } else return false;
            }
            if (s.charAt(i) == '}') {
                if (!stack1.isEmpty() && stack1.pop().equals('{')) res = true;
                else return false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
}
