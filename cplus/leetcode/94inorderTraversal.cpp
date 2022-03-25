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

vector<int> result94;

void dfs94(TreeNode* root){
    if (root!= nullptr){
        dfs94(root->left);
        result94.emplace_back(root->val);
        dfs94(root->right);
    }
}

vector<int> inorderTraversal(TreeNode* root) {
    vector<int> res;
    stack<TreeNode *> st;
    TreeNode *node = root;
    while (!st.empty() or node != nullptr) {
        while (node != nullptr) {
            st.push(node);
            node = node->left;
        }
        if (!st.empty()){
            node = st.top()->right;
            res.emplace_back(st.top()->val);
            st.pop();
        }
    }
    return res;
}