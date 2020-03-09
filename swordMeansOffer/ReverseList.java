package swordMeansOffer;

import java.util.Stack;

/**
 * @author: slwhy
 * @description: 输入一个链表，反转链表后，输出新链表的表头
 * @date: 2019/5/2
 */



public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return null;
        }
        Stack<ListNode> stack1 = new Stack<ListNode>();
        while (head!=null){
            stack1.push(head);
            head = head.next;
        }
        ListNode newHead = stack1.pop();
        ListNode p = newHead;
        while (!stack1.empty()){
            p.next = stack1.pop();
            p = p.next;
        }
        p.next = null;
        return newHead;

    }
}
