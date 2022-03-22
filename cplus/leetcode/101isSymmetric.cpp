//
// Created by slwhy on 2022/3/22.
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

bool dfs(TreeNode *leftNode, TreeNode *rightNode) {
    if (leftNode == nullptr && rightNode == nullptr) return true;
    else if (leftNode != nullptr && rightNode != nullptr) {
        return leftNode->val == rightNode->val && dfs(leftNode->left, rightNode->right) &&
               dfs(leftNode->right, rightNode->left);
    } else return false;
}

bool isSymmetric(TreeNode *root) {
    return dfs(root->left, root->right);
}