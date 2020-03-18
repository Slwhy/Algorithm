package leetcode.primary;

/**
 * @author: slwhy
 * @date: 2020/3/18
 * @description: 101. 对称二叉树
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2020/3/18
         * @Param [root]
         * @return boolean
         * @Description 注意镜像树, 并不是所有的子树都是镜像树,看成两颗树照镜子
         **/
        if (root == null || (root.left == null && root.right == null)) return true;
        return isSymmetricCore(root.left, root.right);
    }

    public boolean isSymmetricCore(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode != null && rightNode != null)
            return isSymmetricCore(leftNode.left, rightNode.right) && isSymmetricCore(leftNode.right, rightNode.left) && leftNode.val == rightNode.val;
        else if (leftNode == null && rightNode == null) return true;
        else return false;
    }
}
