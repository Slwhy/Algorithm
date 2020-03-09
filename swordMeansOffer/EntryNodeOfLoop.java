package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/9
 * @description: 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null
 */
public class EntryNodeOfLoop {
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        /**
         * @Author slwhy
         * @Date 2019/9/9
         * @Param [pHead]
         * @return swordMeansOffer.ListNode
         * @Description 思想:快慢指针,先判断是否有环，
         * 如果有环，则将快指针重新指向head，慢指针不变，
         * 两个指针相等时，即环的入口，（两个指针同时以步长1移动）
         * 注意问题:
         * 1，做的时候，不能直接quick = quick.next.next，因为可能不存在
         * 2，找入口时要先判断两个指针是否相等，再开始移动，否则当整个链表为环时会返回第二个元素
         **/
        boolean isLoop = false;
        ListNode quick = pHead;
        ListNode small = pHead;
        while (quick != null) {
            small = small.next;
            quick = quick.next;
            if (quick != null) {
                quick = quick.next;
                if (small == quick) {
                    isLoop = true;
                    break;
                }
            }

        }
        if (isLoop == false) {
            return null;
        } else {
            quick = pHead;
            while (quick != null) {
                if (small == quick) {
                    break;
                }
                quick = quick.next;
                small = small.next;
            }
        }
        return small;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node3;
        System.out.println(entryNodeOfLoop(node1));


    }
}
