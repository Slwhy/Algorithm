//
// Created by slwhy on 2022/2/23.
//
#include "vector"
#include "map"

using namespace std;


vector<int> twoSum(vector<int> &nums, int target) {
    map<int, int> numMap;
    for (int i = 0; i < nums.size(); ++i) {
        numMap.insert(pair<int, int>(nums[i], i));
    }
    for (int i = 0; i < nums.size(); ++i) {
        if (numMap.find(target-nums[i])!=numMap.end() && numMap.find(target-nums[i])->second!=i) return {i,numMap.find(target-nums[i])->second};
    }
    return {0,0};
}