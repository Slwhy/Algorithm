//
// Created by slwhy on 2022/3/22.
//
#include "vector"
#include "queue"

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

vector<vector<int>> levelOrder(TreeNode *root) {
    vector<vector<int>> res;
    queue<TreeNode *> q;
    int num;
    if (root!= nullptr) q.push(root);
    while (!q.empty()) {
        vector<int> currLayer;
        num = q.size();
        for (int i = 0; i < num; ++i) {
            TreeNode *node = q.front();
            q.pop();
            currLayer.emplace_back(node->val);
            if (node->left != nullptr) q.push(node->left);
            if (node->right != nullptr) q.push(node->right);
        }
        res.emplace_back(currLayer);
    }
    return res;
}