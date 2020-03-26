package leetcode.medium;

/**
 * @author: slwhy
 * @date: 2020/3/26
 * @description: 328. 奇偶链表
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        /**
         * @Author slwhy
         * @Date 2020/3/26
         * @Param [head]
         * @return leetcode.medium.ListNode
         * @Description 快慢指针,节点如何进行替换需要画图好好捋清楚,要不然很容易弄错了
         **/
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head;
        ListNode pre = head.next;
        ListNode p = head.next.next;
        ListNode tmp = null;
        while (p != null) {
            tmp = odd.next;
            odd.next = p;
            pre.next = p.next;
            pre = pre.next;
            odd = odd.next;
            odd.next = tmp;
            if (pre == null) break;
            p = pre.next;
        }
        return head;
    }
}
