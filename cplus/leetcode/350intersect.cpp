//
// Created by slwhy on 2022/3/14.
//
#include "vector"
#include "map"

using namespace std;

vector<int> intersect(vector<int> &nums1, vector<int> &nums2) {
    // 可以优化掉第二个map
    // 还可以排序后用双指针
    vector<int> res;
    map<int, int> map1, map2;
    for (int i = 0; i < nums1.size(); ++i) {
        if (map1.find(nums1[i]) != map1.end()) map1.find(nums1[i])->second += 1;
        else map1.insert(pair<int, int>(nums1[i], 1));
    }
    for (int i = 0; i < nums2.size(); ++i) {
        if (map2.find(nums2[i]) != map2.end()) map2.find(nums2[i])->second += 1;
        else map2.insert(pair<int, int>(nums2[i], 1));
    }
    for (auto itr = map1.begin(); itr != map1.end(); itr++) {
        if (map2.find(itr->first) != map2.end()) {
            int n2 = map2.find(itr->first)->second;
            int count = itr->second > n2 ? n2 : itr->second;
            for (int i = 0; i < count; ++i) {
                res.emplace_back(itr->first);
            }
        }
    }
    return res;
}
