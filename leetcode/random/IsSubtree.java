package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/5/7
 * @description: 572. 另一个树的子树
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t != null) return false;
        if (s == null) return true;
        return helper(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean helper(TreeNode s, TreeNode t) {
        if (t == null && s == null) return true;
        else if (s == null || t == null) return false;
        return s.val == t.val && helper(s.left, t.left) && helper(s.right, t.right);
    }

}
