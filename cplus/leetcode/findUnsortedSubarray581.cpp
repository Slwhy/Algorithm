//
// Created by slwhy on 2021/8/3.
// Desc:581. 最短无序连续子数组
//
#include "vector"
#include "algorithm"

using namespace std;

class Solution {
public:
    int findUnsortedSubarray(vector<int> &nums) {
        /*
         * 对原始数组进行排序，再和原始数组对比出需要排序的最小子串部分
         */
        vector<int> numSort(nums);
        sort(numSort.begin(), numSort.end());
        int begin = 0, end = nums.size() - 1;
        while (begin < nums.size() && nums[begin] == numSort[begin]) begin++;
        while (end > begin && nums[end] == numSort[end]) end--;
        if (begin >= end) return 0;
        else return end - begin + 1;
    }
};

