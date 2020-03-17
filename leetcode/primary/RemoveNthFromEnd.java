package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/17
 * @description: 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode last = head;
        ListNode p = head;
        ListNode root = new ListNode(0);
        ListNode pre = root;
        pre.next = head;
        int i = 0;
        for (; i < n && last != null; i++) {
            last = last.next;
        }
        if (i < n) return head;
        while (last != null) {
            last = last.next;
            p = p.next;
            pre = pre.next;
        }
        pre.next = p.next;
        return root.next;
    }
}
