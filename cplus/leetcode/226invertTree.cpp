//
// Created by slwhy on 2022/3/23.
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

void dfs226(TreeNode *node) {
    if (node != nullptr) {
        dfs226(node->left);
        dfs226(node->right);
        TreeNode* tmp = node->left;
        node->left = node->right;
        node->right = tmp;
    }

}

TreeNode *invertTree(TreeNode *root) {
    dfs226(root);
    return root;
}
