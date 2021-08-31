//
// Created by slwhy on 2021/8/12.
// Desc:446. 等差数列划分 II - 子序列
//
//TODO 第一遍没出来

#include "vector"
#include "unordered_map"

using namespace std;
int numberOfArithmeticSlices1(vector<int>& nums) {
    int ans = 0;
    int n = nums.size();
    vector<unordered_map<long long, int>> f(n);
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < i; ++j) {
            long long d = 1LL * nums[i] - nums[j];
            auto it = f[j].find(d);
            int cnt = it == f[j].end() ? 0 : it->second;
            ans += cnt;
            f[i][d] += cnt + 1;
        }
    }
    return ans;

}


