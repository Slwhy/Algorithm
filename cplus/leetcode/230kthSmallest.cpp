//
// Created by slwhy on 2022/3/1.
//
#include "iostream"
#include "vector"

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

void forwardDfs(TreeNode *node, vector<int> &nums) {
    // 中序遍历
    if (node != nullptr) {
        forwardDfs(node->left, nums);
        nums.emplace_back(node->val);
        forwardDfs(node->right, nums);
    }
}

int kthSmallest(TreeNode *root, int k) {
    vector<int> nums;
    forwardDfs(root, nums);
    return nums[k-1];
}
