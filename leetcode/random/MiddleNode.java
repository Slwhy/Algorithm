package leetcode.random;

import java.util.ArrayList;

/**
 * @author: slwhy
 * @date: 2020/3/23
 * @description: 876. 链表的中间结点
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        ListNode quick = head;
        ListNode small = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            small = small.next;
        }
        return small;

    }

    public ListNode middleNode1(ListNode head) {
        int count = 0;
        ArrayList<ListNode> tmp = new ArrayList<>();
//        head = head.next;
        while (head != null) {
            tmp.add(head);
            head = head.next;
            count++;
        }
        return tmp.get(count / 2);
    }
}
