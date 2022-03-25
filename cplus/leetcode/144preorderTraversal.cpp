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

vector<int> result144;

void dfs144(TreeNode *root) {
    if (root != nullptr) {
        result144.emplace_back(root->val);
        dfs144(root->left);
        dfs144(root->right);
    }
}

vector<int> preorderTraversal(TreeNode *root) {
    // 非递归前序遍历
    vector<int> res;
    stack<TreeNode *> st;
    TreeNode *node = root;
    while (!st.empty() or node != nullptr) {
        while (node != nullptr) {
            res.emplace_back(node->val);
            st.push(node);
            node = node->left;
        }
        if (!st.empty()){
            node = st.top()->right;
            st.pop();
        }
    }
    return res;
}