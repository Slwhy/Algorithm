package leetcode;

/**
 * @author: slwhy
 * @date: 2020/3/13
 * @description: 面试题68 - I. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * @Author slwhy
         * @Date 2020/3/13
         * @Param [root, p, q]
         * @return leetcode.TreeNode
         * @Description 抓住二叉搜索树的性质, 左边比跟节点小, 右边比根节点大
         **/
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)) return root;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }


}
