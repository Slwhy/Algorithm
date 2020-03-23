package leetcode.random;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2020/3/7
 * @description: 面试题59 - II. 队列的最大值
 */
public class MaxQueue {

    public Queue queue = new LinkedList();
    public Deque queueSort = new LinkedList();

    public MaxQueue() {

    }

    public int max_value() {
        if (queue.isEmpty()) return -1;
        return (int) queueSort.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        if (queueSort.isEmpty()) queueSort.offer(value);
        else {
            while (!queueSort.isEmpty() && (int) queueSort.peekLast() < value) queueSort.pollLast();
            queueSort.offer(value);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if ((int) queue.peek() == (int) queueSort.peekFirst()) queueSort.pollFirst();
        return (int) queue.poll();
    }

    public static void main(String[] args) {
        MaxQueue obj = new MaxQueue();
        int param_1 = obj.max_value();
        obj.push_back(10);
        int param_3 = obj.pop_front();
    }
}


/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
