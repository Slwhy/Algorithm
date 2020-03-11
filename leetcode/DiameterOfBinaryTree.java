package leetcode;

/**
 * @author: slwhy
 * @date: 2020/3/10
 * @description: 543. 二叉树的直径
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class DiameterOfBinaryTree {
    public int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2020/3/10
         * @Param [root]
         * @return int
         * @Description BFS, 递归思路，自底向上。
         * 每棵子树的直径等于 左子树深度+右子树深度+1,设置一个成员变量，保存所有子树直径中的最大值，
         * 代码中计算的是经过的节点数，直径应该减去1
         **/
        diameterOfBinaryTreeCore(root);
        return diameter == 0 ? 0 : diameter - 1;
    }

    public int diameterOfBinaryTreeCore(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTreeCore(root.left);
        int right = diameterOfBinaryTreeCore(root.right);
        if (diameter < left + 1 + right) diameter = left + 1 + right;
        return Math.max(left, right) + 1;
    }
}
