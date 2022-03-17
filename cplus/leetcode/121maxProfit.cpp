//
// Created by slwhy on 2022/3/14.
//
#include "vector"

using namespace std;

int maxProfit(vector<int> &prices) {
    // 记录下当前为止最便宜的价格，作为买入价格，而后计算当前时刻的收益
    if (prices.size() < 1) return 0;
    int start = prices[0];
    int res = 0;
    for (int i = 0; i < prices.size(); ++i) {
        int profit = prices[i] - start;
        if (profit < 0) start = prices[i];
        else res = res > profit ? res : profit;
    }
    return res;
}

