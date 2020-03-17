package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/17
 * @description: 合并两个有序链表
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
                continue;
            } else {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        p.next = p1 == null ? p2 : p1;
        return head.next;
    }
}
