package swordMeansOffer;

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

/**
 * @author: slwhy
 * @description: 输入一个复杂链表
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @date: 2019/5/23
 */
public class CloneLinkList {
    public static RandomListNode Clone1(RandomListNode pHead) {
        /**
         * @description 参考牛客上的代码，但还存在一些问题，已经解决
         * @author slwhy
         * @date 2019/5/23
         * @param pHead
         * @return swordMeansOffer.RandomListNode
         */

        if (pHead == null) {
            return null;
        }
        RandomListNode pre;
        RandomListNode p;
        p = pHead;
        while (p != null) {
            RandomListNode node = new RandomListNode(p.label);
            node.next = p.next;
            p.next = node;
            p = p.next.next;
        }
        pre = pHead;
        p = pHead.next;
        while (p.next != null) {
            if (pre.random != null) {
                p.random = pre.random.next;
            }
            pre = pre.next.next;
            p = p.next.next;
        }
        RandomListNode res = pHead.next;
        /*  拆分链表的时候没有拆分好,存在原链对拷贝链的引用
            pre = pHead;
            p = pHead.next;
            while (p.next != null) {
                pre.next = pre.next.next;
                p.next = p.next.next;
                pre = pre.next;
                p = p.next;
            }
         */
        pre = pHead;
        p = pHead.next;
        while (p != null) {
            pre.next = pre.next == null ? null : pre.next.next;
            p.next = p.next == null ? null : p.next.next;
            pre = pre.next;
            p = p.next;
        }
        return res;
    }

    public RandomListNode Clone(RandomListNode pHead) {
        /**
         * @description 自己的思路，时间复杂度比较高
         * @author slwhy
         * @date 2019/5/23
         * @param pHead
         * @return swordMeansOffer.RandomListNode
         */

        if (pHead == null) {
            return null;
        }
        RandomListNode res = new RandomListNode(pHead.label);
        RandomListNode p = res;
        RandomListNode source = pHead.next;
        while (source != null) {
            p.next = new RandomListNode(source.label);
            p = p.next;
            source = source.next;
        }
        RandomListNode randsouce = pHead;
        RandomListNode rand = res;
        p = res;
        source = pHead;
        while (source != null) {
            randsouce = pHead;
            rand = res;
            while (randsouce != source.random) {
                randsouce = randsouce.next;
                rand = rand.next;
            }
            p.random = rand;
            source = source.next;
            p = p.next;
        }

        return res;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2 = new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        head.random = node2;
        Clone1(head);

    }
}
