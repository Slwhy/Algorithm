//
// Created by slwhy on 2021/8/13.
// Desc:516. 最长回文子序列
// TODO 第一遍未想到
// 看了思路才写出来
//

#include "string"
#include "vector"

using namespace std;

int longestPalindromeSubseq(string s) {
    /*
     * dp 解法
     */
    int len = s.size();
    vector<vector<int>> dp(len, vector<int>(len, 0));
    for (int left = len - 1; left >= 0; --left) {
        dp[left][left] = 1;
        for (int right = left + 1; right < len; ++right) {
            if (s[left] == s[right]) dp[left][right] = dp[left + 1][right - 1] + 2;
            else
                dp[left][right] = dp[left + 1][right] > dp[left][right - 1] ? dp[left + 1][right] : dp[left][right - 1];
        }
    }
    return dp[0][len-1];
}
