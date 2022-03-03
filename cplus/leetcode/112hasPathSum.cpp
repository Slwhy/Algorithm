//
// Created by slwhy on 2022/3/1.
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

bool hasPathSumDfs(TreeNode *node, int targetSum) {
    if (node != nullptr) {
        targetSum = targetSum - node->val;
        if (node->left == nullptr && node->right == nullptr) {
            if (targetSum == 0) return true;
        }
        else return hasPathSumDfs(node->left, targetSum) || hasPathSumDfs(node->right, targetSum);
    }
    return false;
}

bool hasPathSum(TreeNode *root, int targetSum) {
    //if (root == nullptr) return false;
    return hasPathSumDfs(root, targetSum);
}
