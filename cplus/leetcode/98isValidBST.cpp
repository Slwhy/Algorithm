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

vector<int> array98;

void dfs98(TreeNode *node) {
    if (node != nullptr) {
        dfs98(node->left);
        array98.emplace_back(node->val);
        dfs98(node->right);
    }
}

bool isValidBST(TreeNode *root) {
    dfs98(root);
    if (array98.size() < 2) return true;
    for (int i = 1; i < array98.size(); ++i) {
        if (array98[i]<=array98[i-1]) return false;
    }
    return true;
}
