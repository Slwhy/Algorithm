//
// Created by slwhy on 2022/2/19.
//
#include "vector"
#include "set"

using namespace std;

vector<vector<int>> res;



void combineCore2(vector<int> curr, int n, int k, int index) {
    // 以每个数选与不选，构造二叉树
    if (curr.size() == k)res.emplace_back(curr);
    else if (curr.size() + (n - index + 1) >= k) {
        curr.emplace_back(index);
        combineCore2(curr, n, k, index + 1);
        curr.pop_back();
        combineCore2(curr, n, k, index + 1);
    }
}

void combineCore(vector<int> curr, int n, int k, int index) {
    if (curr.size() == k)res.emplace_back(curr);
        // 这个else if 对于一些肯定不满足的情况进行了剪枝
        //else if (curr.size() + (n - index + 1) >= k) {
    else {
        for (int i = index; i <= n + 1 - k + curr.size(); ++i) {
            curr.emplace_back(i);
            combineCore(curr, n, k, i + 1);
            curr.pop_back();
        }
    }

}

vector<vector<int>> combine(int n, int k) {
    vector<int> tmp;
    combineCore(tmp, n, k, 1);
    return res;
}