package swordMeansOffer;

import java.util.Stack;

/**问题：利用两个栈，实现一个队列
 *
 * 思路：根据负负得正的概念，一个栈是先进后出，那如果同时经过两个栈，就变成先进先出了，也就是队列的效果
 * 对stack1执行进队操作
 * 对stack2执行出对操作
 * 要注意两点，每次进队之前，要保证stack2是空的，每次出队之前，要保证stack1为空
 * 原因是，如果进队之前，不保证stack2为空，那么如果要执行一个进队，以及出队操作，
 * 也就是，stack1.push（num），stack2.push(stack1.pop)，stack2.pop，就会出现刚进队的数据num马上就出来了，
 * 而原本在stack2中的数据应该是要先出来的，却反而在num数据的后面
 * 而出队之前，必须保证stack1为空，是因为，stack1内，最下面的就是最先进队的数据，所以出队的时候，要让他们先出队
 * */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if (!stack2.empty()){
            while (!stack2.empty()){
                stack1.push(stack2.pop());
            }
        }
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.empty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackToQueue s = new StackToQueue();
        for (int i = 1;i<=3;i++){
            s.push(i);
        }
        for (int i=1;i<=2;i++){
            System.out.println(s.pop());
        }
        s.push(4);
        System.out.println(s.pop());
        s.push(5);
        for (int i=1;i<=2;i++){
            System.out.println(s.pop());
        }
    }
}
