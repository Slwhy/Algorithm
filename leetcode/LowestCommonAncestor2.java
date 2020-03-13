package leetcode;

/**
 * @author: slwhy
 * @date: 2020/3/13
 * @description: 面试题68 - II. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor2 {
    public TreeNode res;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * @Author slwhy
         * @Date 2020/3/14
         * @Param [root, p, q]
         * @return leetcode.TreeNode
         * @Description leetcode上的递归解法
         **/
        if (root == null || root == p || root == q)
            return root;

        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);

        if (leftNode == null)
            return rightNode;
        if (rightNode == null)
            return leftNode;

        return root;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        lowestCommonAncestorCore(root, p, q);
        return res;
    }

    public int lowestCommonAncestorCore(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * @Author slwhy
         * @Date 2020/3/13
         * @Param [root, p, q]
         * @return int
         * @Description 自己想出来的, 通过遍历数组,统计左右子树中出现的pq的个数
         * 如果左子树有pq中的一个,右子树有pq中的一个,则root节点为结果
         * 如果左子树中有pq中的一个,root节点等于pq中的一个,则root节点为结果
         **/
        if (root != null) {
            int left = lowestCommonAncestorCore(root.left, p, q);
            int right = lowestCommonAncestorCore(root.right, p, q);
            if (left == 1 && right == 1) res = root;
            if (left + right == 1 && (root == p || root == q)) res = root;
            if (root == p || root == q) return left + right + 1;
            return left + right;
        } else return 0;
    }
}
