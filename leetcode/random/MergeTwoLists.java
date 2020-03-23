package leetcode.random;

/**
 * @author: slwhy
 * @date: 2019/10/22
 * @description: num 21
 */


public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode res = new ListNode(0);
        ListNode p = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = p.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            p.next = l1;
        } else p.next = l2;
        return res.next;
    }

    public static void main(String[] args) {

    }
}
