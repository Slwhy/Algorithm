package swordMeansOffer;

/**
 * @author: slwhy
 * @description: 操作给定的二叉树，将其变换为源二叉树的镜像
 * @date: 2019/5/3
 */
public class MirrorTree {
    public void Mirror(TreeNode root) {
        if (root!=null){ //要记得添加递归终止条件
            TreeNode node ;
            node = root.right;
            root.right = root.left;
            root.left = node;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    public static void main(String[] args) {

    }
}
