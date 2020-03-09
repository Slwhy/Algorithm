package swordMeansOffer;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: slwhy
 * @description: 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
 * @date: 2019/5/24
 */
public class TreeToLink {
    public ArrayList<TreeNode> res = new ArrayList<TreeNode>();

    public TreeNode Convert(TreeNode pRootOfTree) {
        /**
         * @description 利用递归实现中序遍历，利用成员变量保存结果
         * @author slwhy
         * @date 2019/5/24
         * @param pRootOfTree
         * @return swordMeansOffer.TreeNode
         */

        if (pRootOfTree == null) {
            return null;
        }
        adjust(pRootOfTree);
        for (int i = 0; i < res.size() - 1; i++) {
            res.get(i).right = res.get(i + 1);
            res.get(i + 1).left = res.get(i);
        }
        res.get(0).left = null;
        res.get(res.size() - 1).right = null;
        return res.get(0);
    }

    public void adjust(TreeNode root) {
        if (root != null) {
            adjust(root.left);
            res.add(root);
            adjust(root.right);
        }
    }

    public TreeNode Convert1(TreeNode pRootOfTree) {
        /**
         * @description 非递归实现中序遍历，参考牛客的代码
         * @author slwhy
         * @date 2019/5/28
         * @param pRootOfTree
         * @return swordMeansOffer.TreeNode
         */

        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        TreeNode p, pre;
        pre = null;
        boolean isFrist = true;
        p = pRootOfTree;
        while (p != null || !stack1.isEmpty()) {
            while (p != null) {
                stack1.push(p);
                p = p.left;
            }
            p = stack1.pop();
            if (isFrist) {
                pRootOfTree = p;
                pre = pRootOfTree;
                isFrist = false;
            } else {
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            p = p.right;
        }
        return pRootOfTree;
    }

    private TreeNode tail;

    public TreeNode Convert2(TreeNode pRootOfTree) {
        /**
         * @description 递归实现中序遍历，参考牛客代码
         * @author slwhy
         * @date 2019/5/28
         * @param pRootOfTree
         * @return swordMeansOffer.TreeNode
         */

        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            tail = pRootOfTree;
            return pRootOfTree;
        }
        TreeNode left, right;
        left = Convert2(pRootOfTree.left);
        if (left != null) {
            tail.right = pRootOfTree;
            pRootOfTree.left = tail;
        }
        tail = pRootOfTree;
        right = Convert2(pRootOfTree.right);
        if (right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }

        return left == null ? pRootOfTree : left;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        TreeToLink text = new TreeToLink();
        TreeNode res = text.Convert2(root);
        while (res != null) {
            System.out.println(res.val);
            res = res.right;
        }

    }
}
