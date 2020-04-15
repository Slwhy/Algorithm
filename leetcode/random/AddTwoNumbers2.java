package leetcode.random;

import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/4/14
 * @description: 445. 两数相加 II
 */
public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * @Author slwhy
         * @Date 2020/4/14
         * @Param [l1, l2]
         * @return leetcode.random.ListNode
         * @Description leetcode 上的解法
         **/
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode pre = null;
        ListNode p;
        int flag = 0;
        int tmp = 0;
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            tmp = stack1.pop().val + stack2.pop().val + flag;
            flag = tmp / 10;
            tmp = tmp % 10;
            p = new ListNode(tmp);
            p.next = pre;
            pre = p;
        }
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            tmp = (stack1.isEmpty() ? stack2.pop().val : stack1.pop().val) + flag;
            flag = tmp / 10;
            tmp = tmp % 10;
            p = new ListNode(tmp);
            p.next = pre;
            pre = p;
        }
        if (flag != 0) {
            p = new ListNode(flag);
            p.next = pre;
            pre = p;
        }
        return pre;

    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        /**
         * @Author slwhy
         * @Date 2020/4/14
         * @Param [l1, l2]
         * @return leetcode.random.ListNode
         * @Description 先将高位到低位的链表逆转后变成低位到高位的链表，就将题目转化为较为简单的两数相加
         **/
        ListNode num1 = reverse(l1);
        ListNode num2 = reverse(l2);
        int flag = 0;
        int tmp;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (num1 != null && num2 != null) {
            tmp = num1.val + num2.val + flag;
            flag = tmp / 10;
            tmp = tmp % 10;
            p.next = new ListNode(tmp);
            p = p.next;
            num1 = num1.next;
            num2 = num2.next;
        }
        ListNode remain = num1 == null ? num2 : num1;
        while (remain != null && flag != 0) {
            tmp = remain.val + flag;
            flag = tmp / 10;
            tmp = tmp % 10;
            p.next = new ListNode(tmp);
            p = p.next;
            remain = remain.next;
        }
        if (flag != 0) {
            p.next = new ListNode(flag);
        } else p.next = remain;
        return reverse(res.next);
    }

    public ListNode reverse(ListNode root) {
        if (root == null || root.next == null) return root;
        ListNode pre = root;
        ListNode p = root.next;
        ListNode tmp;
        while (p != null) {
            tmp = p;
            p = p.next;
            tmp.next = pre;
            pre = tmp;
        }
        root.next = null;
        return pre;
    }
}
