package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: slwhy
 * @date: 2020/4/27
 * @description: 449. 序列化和反序列化二叉搜索树
 */
public class Serialize {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2020/4/27
         * @Param [root]
         * @return java.lang.String
         * @Description 基于层次遍历
         **/

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder encode = new StringBuilder();
        queue.offer(root);
        TreeNode node;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node == null) {
                encode.append("n,");
            } else {
                encode.append(String.valueOf(node.val) + ",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        encode.delete(encode.length() - 1, encode.length());
        return encode.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        if (strings[0].equals("n")) return null;
        TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
        queue.offer(root);
        int index = 1;
        while (index < strings.length && !queue.isEmpty()) {
            TreeNode parent = queue.poll();
            if (strings[index].equals("n")) parent.left = null;
            else {
                TreeNode left = new TreeNode(Integer.valueOf(strings[index]));
                parent.left = left;
                queue.offer(left);
            }
            index++;
            if (index < strings.length) {
                if (strings[index].equals("n")) parent.right = null;
                else {
                    TreeNode right = new TreeNode(Integer.valueOf(strings[index]));
                    parent.right = right;
                    queue.offer(right);
                }
                index++;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        StringBuilder tmp = new StringBuilder();
        tmp.append("1bc,12");
//        tmp.delete(tmp.length()-1,tmp.length());
        for (String s : tmp.toString().split(",")) {
            System.out.println(s);
        }
        System.out.println(tmp.toString());
    }
}
