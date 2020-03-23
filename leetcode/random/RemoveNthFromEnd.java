package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/11/6
 * @description: num 19
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) return head;
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode pre = preHead;
        for (int i = 1; i < n; i++) {
            if (p1 == null) return head;
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            pre = p2;
            p2 = p2.next;
        }
        pre.next = p2.next;
        return preHead.next;
    }
}
