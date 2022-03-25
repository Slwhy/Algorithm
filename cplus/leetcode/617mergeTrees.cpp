//
// Created by slwhy on 2022/2/16.
//
#include "iostream"

using namespace std;

//  Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

TreeNode* dfs617(TreeNode* node1, TreeNode* node2){
    if (node1== nullptr) return node2;
    else if (node2 == nullptr) return node1;
    else{

        node1->val= node1->val+node2->val;
        node1->left = dfs617(node1->left,node2->left);
        node1->right = dfs617(node1->right,node2->right);
        return node1;
    }
}

TreeNode* mergeTrees(TreeNode* root1, TreeNode* root2) {
    return dfs617(root1,root2);
}