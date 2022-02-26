//
// Created by slwhy on 2022/2/26.
//
#include "vector"

using namespace std;


int coinChange(vector<int> &coins, int amount) {
    vector<int> dp(amount + 1, amount + 1);
    dp[0] = 0;
    for (int i = 1; i <= amount; ++i) {
        for (int co:coins) {
            if (co <= i) {
                dp[i] = dp[i] > dp[i - co] + 1 ? dp[i - co] + 1 : dp[i];
            }
        }
    }
    return dp[amount] > amount ? -1 : dp[amount];
}

int res = -1;

void coinChangeCore(vector<int> &coins, int amount, int index, int num) {
    // 贪心+回溯剪枝
    if ((amount > 0) && (res == -1 || res > num) && index >= 0) {
        int n = amount / coins[index];
        for (int i = n; i >= 0; --i) {
            coinChangeCore(coins, amount - i * coins[index], index - 1, num + i);
        }
    } else if (amount == 0) {
        if (res == -1 || res > num) res = num;
    }
}

int coinChange2(vector<int> &coins, int amount) {
    std::sort(coins.begin(), coins.end());
    coinChangeCore(coins, amount, coins.size() - 1, 0);
    return res;
}
