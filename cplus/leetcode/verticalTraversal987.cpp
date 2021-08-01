//
// Created by slwhy on 2021/7/31.
// Desc:失败的一道题
//
#include "vector"
#include<algorithm>
#include "iostream"

using namespace std;


// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;

    TreeNode() : val(0), left(nullptr), right(nullptr) {}

    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

vector<pair<int, pair<int, int>>> columnMap;
int columnMin = 0;
int columnMax = 0;

void dfs(TreeNode *node, int column, int layer) {
    if (node != nullptr) {
        if (columnMin > column) columnMin = column;
        if (columnMax < column) columnMax = column;
        pair<int, pair<int, int>> index;
        index.first = column;
        index.second.first = layer;
        index.second.second = node->val;
        columnMap.emplace_back(index);
        dfs(node->left, column - 1, layer + 1);
        dfs(node->right, column + 1, layer + 1);
    }

}

bool comp(pair<int, int> a, pair<int, int> b) {
    return a.first < b.first;
}


vector<vector<int>> verticalTraversal(TreeNode *root) {
    dfs(root, 0, 0);
    //sort(columnMap.begin(), columnMap.end(), comp);
    vector<vector<pair<int, int>>> rowCloumn;
    rowCloumn.resize(columnMax - columnMin + 10);
    vector<vector<int>> res;
    res.resize(columnMax - columnMin + 10);
    //int columnCurr = columnMap[0].first;
    for (int i = 0; i < columnMap.size(); ++i) {
        rowCloumn[columnMap[i].first - columnMin].emplace_back(
                pair<int, int>(columnMap[i].second.first, columnMap[i].second.second));
    }
    for (int i = 0; i < rowCloumn.size(); ++i) {
        sort(rowCloumn[i].begin(), rowCloumn[i].end(), comp);
//        for (int index = 0; index < rowCloumn[i].size(); ++index) {
//            cout<<rowCloumn[i][index].first<<endl;
//        }
        for (int j = 0; j < rowCloumn[i].size(); ++j) {
            cout << "emplace_back ago" << rowCloumn[i][j].second << endl;
            res[i].push_back(rowCloumn[i][j].second);
            cout << rowCloumn[i][j].second << endl;
        }
    }
    cout << "for third" << endl;
    return res;
}

int main() {

    TreeNode node1(3);
    TreeNode node2(9);
    TreeNode node3(20);
    TreeNode node4(15);
    TreeNode node5(7);
    node1.left = &node2;
    node1.right = &node3;
    node3.left = &node4;
    node3.right = &node5;
    cout << "test" << endl;
    vector<vector<int>> res = verticalTraversal(&node1);
    cout << "func end" << endl;
    for (int i = 0; i < res.size(); ++i) {
        cout << "------" << endl;
        for (int j = 0; j < res[i].size(); ++j) {
            cout << res[i][j] << "\t";
        }
        cout << endl;
    }
    cout << "end" << endl;
    return 1;
}

