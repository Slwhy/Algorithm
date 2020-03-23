package leetcode.random;

import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2019/11/11
 * @description: num 25
 */
public class ReverseKGroup {
    public static ListNode res;

    public static ListNode reverseKGroup(ListNode head, int k) {
        // 倒置用递归，剩余部分要保持源有顺序，所以需要先取出来
        // 代码有待整理，写的很乱，这题做的很不容易
        if (head == null || k < 2) return head;
        int num = 0;
        ListNode p = head;
        while (p != null) {
            num++;
            p = p.next;
        }
        if (num < k) return head;
        ListNode tmp;
        if (num % k == 0) tmp = null;
        else {
            int n = num - num % k;
            p = head;
            while (n-- > 1) {
                p = p.next;
            }
            tmp = p.next;
            p.next = null;
        }
        p = head;
        ListNode root = new ListNode(0);
        res = root;
        ListNode q = head;
        int count;
        while (p != null) {
            p = q;
            count = k;
            while (count-- > 0) p = p.next;
            reverseKGroupCore(q, k, k);
            res = q;
            q = p;
        }
        res.next = tmp;
        return root.next;
    }

    public static void reverseKGroupCore(ListNode head, int k, int n) {
        if (n > 1) {
            reverseKGroupCore(head.next, k, n - 1);
        }
        res.next = head;
        res = res.next;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        //num 25
        //用堆栈，空间超了
        if (head == null || k < 2) return head;
        ListNode root = new ListNode(0);
        root.next = head;
        Stack<ListNode> stack1 = new Stack<ListNode>();
        ListNode source = head;
        ListNode target = root;
        ListNode tail = root;
        boolean isK = false;
        while (source != null) {
            isK = false;
            stack1.push(source);
            source = source.next;
            if (stack1.size() == k) {
                isK = true;
                while (!stack1.isEmpty()) {
                    target.next = stack1.pop();
                    target = target.next;
                }
                tail = source;
            }
        }
        if (!isK) target.next = tail;
        return root.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        reverseKGroup(node1, 3);
    }

}
