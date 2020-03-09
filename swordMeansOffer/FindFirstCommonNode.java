package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 输入两个链表，找出它们的第一个公共结点
 * @date: 2019/8/27
 */
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        /**
         * @description 自己想出的：（有公共节点的单链表公用尾部）先统计长度，
         * 去除多出来的那部分，在同时对两个链表进行遍历，找到相同的
         * 牛客上有一个不用，统计长度的算法，交替遍历两个链表
         * https://www.nowcoder.com/profile/187411/codeBookDetail?submissionId=19271404
         * @author slwhy
         * @date 2019/8/27
         * @param pHead1
         * @param pHead2
         * @return swordMeansOffer.ListNode
         */

        int num1 = 0;
        int num2 = 0;
        ListNode p1, p2;
        p1 = pHead1;
        p2 = pHead2;
        while (p1 != null) {
            num1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            num2++;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        if (num1 > num2) {
            for (int i = 0; i < num1 - num2; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < num2 - num1; i++) {
                p2 = p2.next;
            }
        }
        while (p1 != null && p2 != null) {
            if (p1 == p2) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
