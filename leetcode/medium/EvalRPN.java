package leetcode.medium;


import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/5/11
 * @description: 150. 逆波兰表达式求值
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int tmp = 0;
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                num2 = Integer.valueOf(stack.pop());
                num1 = Integer.valueOf(stack.pop());
                tmp = num1 + num2;
                stack.push(Integer.toString(tmp));
            } else if (tokens[i].equals("-")) {
                num2 = Integer.valueOf(stack.pop());
                num1 = Integer.valueOf(stack.pop());
                tmp = num1 - num2;
                stack.push(Integer.toString(tmp));
            } else if (tokens[i].equals("*")) {
                num2 = Integer.valueOf(stack.pop());
                num1 = Integer.valueOf(stack.pop());
                tmp = num1 * num2;
                stack.push(Integer.toString(tmp));
            } else if (tokens[i].equals("/")) {
                num2 = Integer.valueOf(stack.pop());
                num1 = Integer.valueOf(stack.pop());
                tmp = num1 / num2;
                stack.push(Integer.toString(tmp));
            } else {
                stack.push(tokens[i]);
                tmp = Integer.valueOf(tokens[i]);
            }
        }
        return tmp;
    }

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        System.out.println(evalRPN.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
