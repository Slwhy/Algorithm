package swordMeansOffer;

/**
 * @author: slwhy
 * @date: 2019/9/16
 * @description: 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的
 */
public class IsSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        /**
         * @Author slwhy
         * @Date 2019/9/16
         * @Param [pRoot]
         * @return boolean
         * @Description 递归实现
         **/
        if (pRoot == null || (pRoot.right == null && pRoot.left == null)) {
            return true;
        }
        if (pRoot.left != null && pRoot.right != null) {
            return meterical(pRoot.left, pRoot.right);
        }

        return false;
    }

    boolean meterical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return (left.val == right.val) && meterical(left.left, right.right) && meterical(left.right, right.left);
    }
}
