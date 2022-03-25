//
// Created by slwhy on 2022/3/21.
//
#include "vector"
#include "stack"

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

vector<int> result;

void dfs145(TreeNode *root) {
    if (root != nullptr) {
        dfs145(root->left);
        dfs145(root->right);
        result.emplace_back(root->val);

    }
}

vector<int> postorderTraversal(TreeNode *root) {
    vector<int> res;
    stack<TreeNode *> st;
    TreeNode *node = root;
    TreeNode *pre = nullptr;
    while (!st.empty() or node != nullptr) {
        while (node != nullptr) {
            st.push(node);
            node = node->left;
        }
        node = st.top();
        st.pop();
        if (node->right == nullptr || node->right == pre) {
            res.emplace_back(node->val);
            pre = node;
            node = nullptr;
        } else {
            st.push(node);
            node = node->right;
        }
    }
    return res;
}