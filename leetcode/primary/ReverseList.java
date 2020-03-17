package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/17
 * @description: 反转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = head;
        ListNode p = head.next;
        while (p != null) {
            ListNode node = p;
            p = p.next;
            node.next = pre;
            pre = node;
        }
        head.next = null;
        return pre;
    }
}
