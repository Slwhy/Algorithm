package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 * @date: 2019/8/28
 */
public class TreeDepth {
    public static int TreeDepth(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2019/8/28
         * @Param [root]
         * @return int
         * @Description  递归实现，可以思考一下非递归实现方法（不是很清楚）
         **/

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left >= right ? left + 1 : right + 1;
    }

}
