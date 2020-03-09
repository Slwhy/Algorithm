package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
 * @date: 2019/5/3
 */
public class MergeLinklist {

    public ListNode Merge1(ListNode list1, ListNode list2) {
        /**
         * @description 循环版
         * @author slwhy
         * @date 2019/5/3
         * @param list1
         * @param list2
         * @return ListNode
         */

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode l1 = list1;
        ListNode l2 = list2;
        //通过一个带头节点的链表，可以省去下面判断第一个节点的if语句，只需要在返回的时候返回res.next即可
        ListNode res = new ListNode(0);
        ListNode p = res;
//        ListNode res;
//        ListNode p;
//        if (l1.val <= l2.val) {
//            res = l1;
//            l1 = l1.next;
//        } else {
//            res = l2;
//            l2 = l2.next;
//        }
//        p = res;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if (l1 == null) {
            p.next = l2;
        } else {
            p.next = l1;
        }
        return res.next;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        /**
         * @description 递归版
         * @author slwhy
         * @date 2019/5/3
         * @param list1
         * @param list2
         * @return ListNode
         */

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1,list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {

    }
}
