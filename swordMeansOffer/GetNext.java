package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/10
 * @description: 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针
 */


class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class GetNext {
    public static TreeLinkNode getNext(TreeLinkNode pNode) {
        /**
         * @Author slwhy
         * @Date 2019/9/11
         * @Param [pNode]
         * @return swordMeansOffer.TreeLinkNode
         * @Description
         * 三种情况考虑:
         * 1,右子树存在，这里要注意，当右子树存在，取的是右子树的中序遍历的第一个节点（要循环）
         * 2,右子树不存在，且当前节点为左孩子
         * 3,右子树不存在，且当前节点为右孩子
         *
         * 牛客:https://www.nowcoder.com/profile/2292789/codeBookDetail?submissionId=20386367
         **/
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else if (pNode.next != null) {
            TreeLinkNode root = pNode.next;
            if (pNode == root.left) {
                return root;
            } else {
                if (root.next != null) {
                    if (root.next.left == root) {
                        return root.next;
                    }
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node2.next = node1;
        node3.left = node6;
        node3.right = node7;
        node3.next = node1;
        node4.left = node8;
        node4.next = node2;
        node5.next = node2;
        node6.next = node3;
        node7.next = node3;
        node8.next = node4;
        System.out.println(getNext(node1).val);


    }

}
