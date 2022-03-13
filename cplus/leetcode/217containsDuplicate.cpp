//
// Created by slwhy on 2022/3/12.
//
#include "vector"
#include "set"
using namespace std;

bool containsDuplicate(vector<int>& nums) {
    set<int> cache;
    for (int i = 0; i < nums.size(); ++i) {
        if (cache.find(nums[i])!=cache.end()) return true;
        cache.insert(nums[i]);
    }
    return false;
}
