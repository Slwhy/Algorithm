//
// Created by slwhy on 2022/2/26.
//
#include "vector"

using namespace std;


bool canPartition(vector<int> &nums) {
    // 基于方法2进行空间优化
    int size = nums.size();
    if (size < 2) return false;
    int sum = 0, max = 0;
    for (int i = 0; i < size; ++i) {
        sum += nums[i];
        max = max > nums[i] ? max : nums[i];
    }
    if (sum % 2 != 0 || max > sum / 2) return false;
    int target = sum / 2;
    vector<bool> dp(target + 1, false);
    dp[0] = true;
    for (int i = 1; i < size; ++i) {
        int num = nums[i];
        // 这个循环为什么要从大到小
        // 因为如果从小到大，更新dp[j] 的时候， dp[j-num] 已经被更新过了，不是 i-1 对应对 dp[j-num]了
        for (int j = target; j >= num; --j) {
            dp[j] = dp[j] || dp[j-num];
        }
    }
    return dp[target];

}

bool canPartition2(vector<int> &nums) {
    // dp解法
    int size = nums.size();
    if (size < 2) return false;
    int sum = 0, max = 0;
    for (int i = 0; i < size; ++i) {
        sum += nums[i];
        max = max > nums[i] ? max : nums[i];
    }
    if (sum % 2 != 0 || max > sum / 2) return false;
    int target = sum / 2;
    vector<vector<bool>> dp(size, vector<bool>(target + 1, false));
    for (int i = 0; i < size; ++i) {
        dp[i][0] = true;
    }
    dp[0][nums[0]] = true;
    for (int i = 1; i < size; ++i) {
        int num = nums[i];
        for (int j = 1; j <= target; ++j) {
            if (num <= j) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - num];
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
    return dp[size - 1][target];
}

bool canPartitionCore(int sum, vector<int> &nums, int index) {
    // 暴力解法
    if (sum < 0 or index >= nums.size()) return false;
    else if (sum == 0) return true;
    else {
        return canPartitionCore(sum, nums, index + 1) || canPartitionCore(sum - nums[index], nums, index + 1);
    }
}

bool canPartition3(vector<int> &nums) {
    if (nums.size() < 2) return false;
    int sum = 0;
    for (int i = 0; i < nums.size(); ++i) {
        sum += nums[i];
    }
    if (sum % 2 != 0) return false;
    sum = sum / 2;
    return canPartitionCore(sum, nums, 0);
}