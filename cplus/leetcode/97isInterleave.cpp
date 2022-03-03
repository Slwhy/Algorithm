//
// Created by slwhy on 2022/3/2.
//
#include "string"
#include "vector"
#include "unordered_map"

using namespace std;

vector<vector<vector<int>>> isInterCache = vector<vector<vector<int>>>(100, vector<vector<int>>(100, vector<int>(200, -1)));

bool isInterLeaveCore(string s1, string s2, string s3, int i, int j, int k) {
    if (i == s1.size() && j == s2.size() && k == s3.size()) return true;
    if (isInterCache[i][j][k] != -1) return isInterCache[i][j][k] == 1;
    bool res1 = false, res2 = false;
    if (i < s1.size() && s1[i] == s3[k]) res1 = isInterLeaveCore(s1, s2, s3, i + 1, j, k + 1);
    if (j < s2.size() && s2[j] == s3[k]) res2 = isInterLeaveCore(s1, s2, s3, i, j + 1, k + 1);
    bool res = res1 || res2;
    if (res) isInterCache[i][j][k] = 1;
    else isInterCache[i][j][k] = 0;
    return res;
}

bool isInterleave(string s1, string s2, string s3) {
    if (s1.size() == 0 && s2.size() == 0 && s3.size() == 0) return true;
    if (s1.size() + s2.size() != s3.size()) return false;
    return isInterLeaveCore(s1, s2, s3, 0, 0, 0);
}
