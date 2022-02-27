//
// Created by slwhy on 2022/2/27.
//
#include "vector"
#include "stack"

using namespace std;


bool find132pattern(vector<int> &nums) {
    stack<int> st;
    int size = nums.size();
    if (size < 3) return false;
    int k = INT_MIN;
    for (int i = size - 1; i >= 0; --i) {
        if (nums[i] < k) return true;
        while (!st.empty() && nums[i]>st.top()){
            k = st.top();
            st.pop();
        }
        st.push(nums[i]);
    }
    return false;
}