package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @date: 2019/5/3
 */
public class SubTree {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        //if的顺序不能发生变化，否则结果错误（如下注释）
//        if (root1 == null) {
//            return false;
//        }
//        if (root2 == null) {
//            return true;
//        }
        if (root1.val == root2.val) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }

}
