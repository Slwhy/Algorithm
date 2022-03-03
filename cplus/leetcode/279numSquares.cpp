//
// Created by slwhy on 2022/2/28.
//
#include "vector"

using namespace std;

int numSquares(int n) {
    vector<int> dp(n + 4, 10001);
    for (int i = 0; i < 4; ++i) {
        dp[i] = i;
    }
    for (int i = 4; i <= n; ++i) {
        int num = 1;
        int squ = num * num;
        while (squ <= i) {
            dp[i] = dp[i] > dp[i - squ] + 1 ? dp[i - squ] + 1 : dp[i];
            num++;
            squ = num * num;
        }
    }
    return dp[n];
}
