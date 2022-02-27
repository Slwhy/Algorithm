//
// Created by slwhy on 2022/2/27.
//
#include "vector"
#include "map"
#include "stack"

using namespace std;

vector<int> nextGreaterElement(vector<int> &nums1, vector<int> &nums2) {
    // 单调栈解法
    stack<int> st;
    map<int, int> num2Res;
    for (int i = nums2.size() - 1; i >= 0; --i) {
        while (!st.empty() && nums2[i] > st.top()) st.pop();
        if (st.empty()) num2Res.emplace(pair<int, int>{nums2[i], -1});
        else num2Res.emplace(pair<int, int>{nums2[i], st.top()});
        st.emplace(nums2[i]);
    }
    for (int i = 0; i < nums1.size(); ++i) {
        nums1[i] = num2Res.find(nums1[i])->second;
    }
    return nums1;
}

vector<int> nextGreaterElement2(vector<int> &nums1, vector<int> &nums2) {
    map<int, int> nums2index;
    for (int i = 0; i < nums2.size(); ++i) {
        nums2index.emplace(pair<int, int>(nums2[i], i));
    }
    for (int i = 0; i < nums1.size(); ++i) {
        int num = nums1[i];
        nums1[i] = -1;
        for (int j = nums2index.find(num)->second; j < nums2.size(); ++j) {
            if (nums2[j] > num) {
                nums1[i] = nums2[j];
                break;
            }
        }
    }
    return nums1;
}