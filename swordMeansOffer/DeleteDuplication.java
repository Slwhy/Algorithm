package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/10
 * @description: 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplication {

    public ListNode deleteDuplication(ListNode pHead) {
        /**
         * @Author slwhy
         * @Date 2019/9/10
         * @Param [pHead]
         * @return swordMeansOffer.ListNode
         * @Description 自己的方法有些蠢
         **/
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode p = pHead;
        int lent = 0;
        while (p != null) {
            p = p.next;
            lent++;
        }
        boolean[] isRemove = new boolean[lent];
        ListNode pre = pHead;
        p = pre.next;
        int i = 0;
        while (p != null) {
            i++;
            if (pre.val == p.val) {
                isRemove[i] = true;
                isRemove[i - 1] = true;
            }
            pre = pre.next;
            p = p.next;
        }
        ListNode head = new ListNode(0);
        head.next = pHead;
        pre = head;
        p = pre.next;
        i = 0;
        while (p != null) {
            if (isRemove[i]) {
                pre.next = p.next;
                p = p.next;
                i++;
                continue;
            }
            pre = pre.next;
            p = p.next;
            i++;
        }
        return head.next;
    }

    public ListNode deleteDuplication1(ListNode pHead) {
        /**
         * @Author slwhy
         * @Date 2019/9/10
         * @Param [pHead]
         * @return swordMeansOffer.ListNode
         * @Description 牛客上的代码，https://www.nowcoder.com/profile/645151/codeBookDetail?submissionId=1521182
         **/
        ListNode first = new ListNode(-1);//设置一个trick
        first.next = pHead;

        ListNode p = pHead;
        ListNode last = first;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val)
                    p = p.next;
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
