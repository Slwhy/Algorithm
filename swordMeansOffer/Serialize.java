package swordMeansOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2019/9/16
 * @description: 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，
 * 序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 */
public class Serialize {
    public static String serialize(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2019/9/16
         * @Param [root]
         * @return java.lang.String
         * @Description 基于层次遍历实现
         **/
        StringBuilder str_buil = new StringBuilder();
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        queue1.offer(root);
        TreeNode node;
        while (!queue1.isEmpty()) {
            node = queue1.poll();
            if (node == null) {
                str_buil.append('#');
                str_buil.append('!');
                continue;
            }
            str_buil.append(node.val);
            str_buil.append('!');
            queue1.offer(node.left);
            queue1.offer(node.right);
        }
        return str_buil.toString();
    }

    public static TreeNode deserialize(String str) {
        /**
         * @Author slwhy
         * @Date 2019/9/16
         * @Param [str]
         * @return swordMeansOffer.TreeNode
         * @Description 利用 ！ 将字符串切割开，而后利用层次遍历实现对二叉树的重构
         **/
        String str_list[] = str.split("!");
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        if (str_list[0].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(str_list[0]));
        TreeNode p = root;
        TreeNode node;
        queue1.offer(root);
        int i = 1;
        while (i < str_list.length) {
            p = queue1.poll();
            if (str_list[i].equals("#")) {
                p.left = null;
                i++;
            } else {
                node = new TreeNode(Integer.parseInt(str_list[i]));
                p.left = node;
                queue1.offer(node);
                i++;
            }
            if (str_list[i].equals("#")) {
                p.right = null;
                i++;
            } else {
                node = new TreeNode(Integer.parseInt(str_list[i]));
                p.right = node;
                queue1.offer(node);
                i++;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        TreeNode node5 = new TreeNode(5);

        //测试代码
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        String res = serialize(null);
        System.out.println(res);
        TreeNode root = deserialize(res);
        String res2 = serialize(root);
        System.out.println(res2);
    }
}
