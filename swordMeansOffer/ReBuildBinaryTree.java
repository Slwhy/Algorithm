package swordMeansOffer;

/**问题：根据中序和前序遍历，重建该二叉树
 *
 *思路：递归的思路很容易想到，做的时候，被如何构造子树的前序遍历序列卡住了，
 * 原本的的想法是将子树的前后遍历序列都提取出来，而后进行递归
 * 发现这样做很难实现，而后查看了别人的博客才发现，只需要定义一首一尾指针即可，不需要对数组进行修改
 * 而且，前序遍历的时候，左子树一定是在右子树的前面，左右子树的长度，可以通过中序遍历求出来，
 * 这样就可以求出左右子树的前序遍历的首尾指针
 * */


//Definition for binary tree
class TreeNode {
  int val;
  TreeNode left=null;
  TreeNode right=null;
  TreeNode(int x) { val = x; }
}

public class ReBuildBinaryTree {
    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre.length==0||in.length==0||pre.length!=in.length){
            return null;
        }
        return construct(pre,0,pre.length-1,in,0,pre.length-1);
    }

    /**
     * pre 前序遍历
     * pres 前序遍历开始的位置
     * pree 前序遍历结束的位置
     * in 后续遍历
     * ins 后续遍历开始的位置
     * ine 后续遍历结束的位置
     * */
    public static TreeNode construct(int [] pre, int pres, int pree, int [] in, int ins, int ine){
        if (pres>pree||ins>ine){
            return null;
        }
        TreeNode node = new TreeNode(pre[pres]);
        int index = ins;
        while (index<=ine){
            if (in[index]==pre[pres]){
                break;
            }
            index++;
        }
        node.left = construct(pre,pres+1,pres+index-ins,in,ins,index-1);
        node.right = construct(pre,pres+index-ins+1,pree,in,index+1,ine);
        return node;
    }

    //中序遍历递归打印
    public static void printTree(TreeNode node){
        if(node!=null){
            printTree(node.left);
            System.out.print(node.val+" ");
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        int[] preOrder={1,2,4,7,3,5,6,8};
        int[] inOrder={4,7,2,1,5,3,8,6};
        TreeNode node=reConstructBinaryTree(preOrder,inOrder);
        printTree(node);

    }
}
