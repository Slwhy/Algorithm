package swordMeansOffer;

import java.util.Stack;

/**
 * @author: slwhy
 * @description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））
 * @date: 2019/5/3
 */
public class StackMin {
    /**
     * @description 参考了别人的博客，不是单纯自己想出的，
     * 博客地址：https://blog.csdn.net/u013132035/article/details/80603691
     * 思路总结：以空间换时间，这个思路都有；
     * 本人的第一反应，开辟一个min变量，每次push进来时都比较一下，保存下最小值
     * 但转念一想，不对，如果这个min被pop出去了怎么办？所以单纯保存一个最小值是行不通的
     * 所以我们需要保存下每次push或者pop后原栈的最小值，如何实现呢？
     * 开辟两个stack，stack1保存输入序列，stack2保存当前最小值序列且栈顶为当前最小值，两个stack的push和pop操作保持同步，
     * 具体实现，分两种情况，1，push后栈顶为最小值，2，pop后栈顶为最小值
     * 每次stack1 push 一个数num时，stack2 push num和min中较小的那个，所以每次push后，stack2的栈顶都是最小值
     * 假设当前stack1的栈顶元素为num，stack1 pop时，stack2也进行pop；就又回到了push进num之前的情况，
     * @author slwhy
     * @date 2019/5/3
     * @param null
     * @return
     */

    Stack<Integer> stack1 = new Stack<Integer>();//原栈
    Stack<Integer> stack2 = new Stack<Integer>();//辅助栈，时刻保存最小序列
    int min = Integer.MAX_VALUE;

    public void push(int node) {
        stack1.push(node);
        if (min > node) {
            min = node;
        }
        stack2.push(min);
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
        min = stack2.peek();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return min;
    }
}
