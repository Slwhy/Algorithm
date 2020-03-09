package leetcode;

import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2020/3/2
 * @description: num 206
 */
public class ReverseList {

    public ListNode reverseList(ListNode head){
        /**
        * @Author slwhy
        * @Date 2020/3/2
        * @Param [head]
        * @return leetcode.ListNode
        * @Description
        **/
        if (head==null||head.next==null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public ListNode reverseList2(ListNode head){
        /**
        * @Author slwhy
        * @Date 2020/3/2
        * @Param [head]
        * @return leetcode.ListNode
        * @Description 双指针迭代，一遍循环，不用栈
        **/
        ListNode pre = null;
        ListNode curr = head;
        ListNode node;
        while (curr!=null){
            node = curr;
            curr = curr.next;
            node.next = pre;
            pre = node;
        }
        return curr;
    }
    public ListNode reverseList3(ListNode head) {
        /**
        * @Author slwhy
        * @Date 2020/3/2
        * @Param [head]
        * @return leetcode.ListNode
        * @Description 直接将所有元素打到栈中，再读出来
        **/
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
