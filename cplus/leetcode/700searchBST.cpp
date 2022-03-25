//
// Created by slwhy on 2022/3/24.
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


TreeNode *searchBST(TreeNode *root, int val) {
    if (root == nullptr || root->val == val) return root;
    if (root->val>val) return searchBST(root->left,val);
    else return searchBST(root->right,val);
}