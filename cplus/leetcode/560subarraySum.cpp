//
// Created by slwhy on 2022/4/5.
//
#include "vector"
#include "map"

using namespace std;

int subarraySum2(vector<int> &nums, int k) {
    map<int, int> prefixMap = map<int, int>();
    int count = 0;
    int sumPrefix = 0;
    // 未遍历数组之前前缀和为0就应该存在1次，这样所有前缀和为k的就会被统计进来
    prefixMap.insert(pair<int, int>(0, 1));
    for (int i = 0; i < nums.size(); ++i) {
        sumPrefix += nums[i];
        if (prefixMap.find(sumPrefix - k) != prefixMap.end()) count += prefixMap.find(sumPrefix - k)->second;
        if (prefixMap.find(sumPrefix) != prefixMap.end()) prefixMap.find(sumPrefix)->second += 1;
        else prefixMap.insert(pair<int, int>(sumPrefix, 1));
    }
    return count;
}

int subarraySum(vector<int> &nums, int k) {
    vector<int> prefixSum = vector<int>(nums.size());
    prefixSum[0] = nums[0];
    int count = 0;
    for (int i = 1; i < nums.size(); ++i) {
        prefixSum[i] = nums[i] + prefixSum[i - 1];
    }
    for (int i = 0; i < nums.size(); ++i) {
        if (prefixSum[i] == k) count++;
    }
    for (int i = 0; i < nums.size() - 1; ++i) {
        for (int j = i + 1; j < nums.size(); ++j) {
            if (prefixSum[j] - prefixSum[i] == k)count++;
        }
    }
    return count;
}
