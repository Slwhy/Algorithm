//
// Created by slwhy on 2022/3/26.
//
#include "vector"

using namespace std;

int majorityElement(vector<int> &nums) {
    int count = 0;
    int num = nums[0];
    for (int i = 0; i < nums.size(); ++i) {
        if (nums[i] == num or count == 0) {
            count++;
            num = nums[i];
        }else count--;
    }
    return num;
}