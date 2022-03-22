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

int res = 0;

void dfs(TreeNode *node, int depth) {
    if (node != nullptr) {
        depth++;
        dfs(node->left,depth);
        dfs(node->right,depth);
    } else {
        res = res > depth ? res : depth;
    }
}

int maxDepth(TreeNode *root) {
    dfs(root,0);
    return res;
}