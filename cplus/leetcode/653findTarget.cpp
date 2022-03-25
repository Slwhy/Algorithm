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

vector<int> array653;

void dfs653(TreeNode *node) {
    if (node != nullptr) {
        dfs653(node->left);
        array653.emplace_back(node->val);
        dfs653(node->right);
    }
}

bool findTarget(TreeNode *root, int k) {
    dfs653(root);
    int left = 0, right = array653.size() - 1;
    while (left < right) {
        if (array653[left] + array653[right] == k) return true;
        else if (array653[left] + array653[right] < k) left++;
        else right--;
    }
    return false;
}