//
// Created by slwhy on 2022/3/13.
//
#include "vector"
#include "queue"

using namespace std;

void merge(vector<int> &nums1, int m, vector<int> &nums2, int n) {
    int index = m + n - 1;
    m--, n--;
    while (n >= 0) {
        if (m < 0) nums1[index--] = nums2[n--];
        else if (nums1[m] > nums2[n]) nums1[index--] = nums1[m--];
        else nums1[index--] = nums2[n--];
    }
}

void merge2(vector<int> &nums1, int m, vector<int> &nums2, int n) {
    queue<int> q;
    int index1 = 0, index2 = 0;
    while (index1 < m + n) {
        if (index1 < m) q.push(nums1[index1]);
        if (!q.empty() && (index2 >= n || q.front() <= nums2[index2])) {
            nums1[index1++] = q.front();
            q.pop();
        } else {
            nums1[index1++] = nums2[index2++];
        }
    }
}