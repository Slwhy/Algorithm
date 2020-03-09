package swordMeansOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: slwhy
 * @date: 2019/9/16
 * @description: 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4
 */
public class KthNode {
    static ArrayList<TreeNode> mid = new ArrayList<TreeNode>();

    static TreeNode KthNode(TreeNode pRoot, int k) {
        /**
         * @Author slwhy
         * @Date 2019/9/16
         * @Param [pRoot, k]
         * @return swordMeansOffer.TreeNode
         * @Description 根据二叉搜索树的特性，中序遍历有序，所以该题要求的是中序遍历的第k个值
         * 非递归版，不熟悉，多捋捋
         **/
        if (k == 0) {
            return null;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
//        stack1.push(pRoot);
        TreeNode node = pRoot;
        int count = 0;
        while (!stack1.isEmpty() || node != null) {
            while (node != null) {
                stack1.push(node);
                node = node.left;
            }
            node = stack1.pop();
            count++;
            if (count == k) {
                return node;
            }
            node = node.right;
//            这个if不能加，加了之后就会一直循环最左边的这个节点，无法跳出
//            if (node.right != null) {
//                node = node.right;
//            }

        }
        return null;
    }

    static TreeNode KthNode1(TreeNode pRoot, int k) {
        /**
         * @Author slwhy
         * @Date 2019/9/16
         * @Param [pRoot, k]
         * @return swordMeansOffer.TreeNode
         * @Description 递归版，思路最简单，利用一个变量保存遍历的序列，而后取出第k个值即可
         **/
        mid_traverse(pRoot);
        if (k > mid.size() || k == 0) {
            return null;
        }
        return mid.get(k - 1);
    }

    static void mid_traverse(TreeNode pRoot) {
        /**
         * @Author slwhy
         * @Date 2019/9/16
         * @Param [pRoot]
         * @return void
         * @Description 递归版中序遍历
         **/
        if (pRoot != null) {
            mid_traverse(pRoot.left);
            mid.add(pRoot);
            mid_traverse(pRoot.right);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;
//        node3.left = node6;
//        node3.right = node7;
//        String res = Serialize(null);
//        System.out.println(res);
//        TreeNode root = Deserialize(res);
//        String res2 = Serialize(root);
//        System.out.println(res2);
        node5.left = node3;
        node5.right = node7;
        node3.left = node2;
        node3.right = node4;
        node7.left = node6;
        node7.right = node8;
        System.out.println(KthNode(node5, 0).val);
    }
}
