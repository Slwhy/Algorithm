package leetcode.primary;

import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/3/20
 * @description: 最小栈
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */
    public Stack stack = new Stack();
    public Stack minStack = new Stack();

    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x < (int) minStack.peek()) minStack.push(x);
            else minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return (int)minStack.peek();
    }
}
