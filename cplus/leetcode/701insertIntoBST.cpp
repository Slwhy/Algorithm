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

void dfs701(TreeNode *node, TreeNode *nodeNew) {
    if (node != nullptr) {
        if (node->val > nodeNew->val) {
            if (node->left == nullptr) node->left = nodeNew;
            else dfs701(node->left, nodeNew);
        } else {
            if (node->right == nullptr) node->right = nodeNew;
            else dfs701(node->right,nodeNew);
        }
    }
}

TreeNode *insertIntoBST(TreeNode *root, int val) {
    TreeNode* node = new TreeNode(val);
    //node->val = val;
    if (root== nullptr) return node;
    else dfs701(root,node);
    return root;
}
