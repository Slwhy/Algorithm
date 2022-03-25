//
// Created by slwhy on 2022/3/25.
//

#include "iostream"
#include "vector"

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

TreeNode *dfs235(TreeNode *node, TreeNode *p, TreeNode *q) {
    if (node != nullptr) {
        if ((node->val - p->val) * (node->val - q->val) <= 0) return node;
        else if (node->val>p->val) return dfs235(node->left,p,q);
        else return dfs235(node->right,p,q);
    }
    return nullptr;
}

TreeNode *lowestCommonAncestor(TreeNode *root, TreeNode *p, TreeNode *q) {
    return dfs235(root,p,q);
}