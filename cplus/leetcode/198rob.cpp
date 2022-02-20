//
// Created by slwhy on 2022/2/20.
//
#include "vector"
#include "iostream"

using namespace std;

int robDp(vector<int> &nums) {
    int leng = nums.size();
    int dp[leng + 3];
    int res = 0;
    for (int i = 0; i < 3; ++i) {
        dp[i] = 0;
    }
    for (int i = 0; i < leng; ++i) {
        int index = i + 3;
        dp[index] = max(dp[index - 2], dp[index - 3]) + nums[i];
        res = max(res, dp[index]);
    }
    return res;
}

int robDp2(vector<int> &nums) {
    //dp空间优化
    int leng = nums.size();
    int dp[4];
    int res=0;
    for (int i = 0; i < 3; ++i) {
        dp[i] = 0;
    }
    for (int i = 0; i < leng; ++i) {
        dp[3] = max(dp[0], dp[1]) + nums[i];
        res = max(res, dp[3]);
        for (int j = 1; j < 4; ++j) {
            dp[j - 1] = dp[j];
        }
    }
    return res;
}

int rob(vector<int> &nums) {
    return 0;
}


