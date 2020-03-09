package swordMeansOffer;

/**
 * @author: slwhy
 * @description: TODO
 * @date: 2019/8/28
 */
public class IsBalanced {
    public boolean isbalance = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        /**
        * @Author slwhy
        * @Date 2019/8/28
        * @Param [root]
        * @return boolean
        * @Description //设置一个标志位，只需要递归一遍树即可得到结果，
         * 但有一个问题，如果把属性和变量都设置为static，无法通过{1}的case，但本地可以
        **/
        treeDepth(root);
        return isbalance;
    }

    public int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isbalance = false;
        }
        return left >= right ? left + 1 : right + 1;
    }

    public static boolean IsBalanced(TreeNode root) {
        /**
         * @Author slwhy
         * @Date 2019/8/28
         * @Param [root]
         * @return boolean
         * @Description //利用递归的思想遍历树，判断每个节点对应的左右子树的高度差
         **/
        if (root == null) {
            return true;
        }

        if (Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) > 1) {
            return false;
        }
        return IsBalanced(root.left) && IsBalanced(root.right);

    }

    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left >= right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        System.out.println(IsBalanced(node1));
    }

}
