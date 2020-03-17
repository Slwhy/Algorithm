package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/17
 * @description: 删除链表中的节点
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode p = node.next;
        ListNode pre = node;
        while (p.next != null) {
            pre.val = p.val;
            p = p.next;
            pre = pre.next;
        }
        pre.val = p.val;
        pre.next = null;
    }
}
