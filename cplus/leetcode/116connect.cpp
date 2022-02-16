//
// Created by slwhy on 2022/2/16.
//
// Definition for a Node.

#include "iostream"
#include "queue"
#include "math.h"

using namespace std;

class Node {
public:
    int val;
    Node *left;
    Node *right;
    Node *next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node *_left, Node *_right, Node *_next)
            : val(_val), left(_left), right(_right), next(_next) {}
};

void dfs(Node *node1, Node *node2) {
    // 此方法适用于完美二叉树
    // 如果不是完美二叉树，需要对两个节点的子节点分情况考虑
    if (node1 != nullptr && node2 != nullptr && node1->next == nullptr) {
        node1->next = node2;
        dfs(node1->left, node1->right);
        dfs(node1->right, node2->left);
        dfs(node2->left, node2->right);
    }
}

Node *layerTraver(Node *root) {
    //    层次遍历
    // 当不是完美二叉树的时候，就不能用这种方式判断每一层的节点
    // 而应该在每次循环开始的时候取到当前queue中的节点数量，再利用一个循环处理这些节点(这些节点都是同一层的)
    queue<Node *> queue;
    queue.push(root);
    int count = 0;
    double layer = 1;
    while (!queue.empty() && queue.front() != nullptr) {
        count++;
        if (count == pow(2.0, layer) - 1) {
            layer++;
            queue.push(queue.front()->left);
            queue.push(queue.front()->right);
            queue.pop();
        } else {
            Node *tmp = queue.front();
            queue.pop();
            tmp->next = queue.front();
            queue.push(tmp->left);
            queue.push(tmp->right);
        }
    }
    return root;
}

Node *connect(Node *root) {
    if (root != nullptr) dfs(root->left, root->right);
    return root;
}

