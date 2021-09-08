//
// Created by slwhy on 2021/8/1.
// Desc:1337. 矩阵中战斗力最弱的 K 行
//
#include "vector"


using namespace std;


vector<int> kWeakestRows(vector<vector<int>> &mat, int k) {
    vector<pair<int, int>> indexMap;
    vector<int> res;
    for (int i = 0; i < mat.size(); ++i) {
        int j = 0;
        int count = 0;
        while (j < mat[0].size() && mat[i][j] == 1) {
            count++;
            j++;
        }
        indexMap.emplace_back(pair<int, int>(i, count));
    }
    //自己手写冒泡排序
    int indexTmp;
    int valueTmp;
    for (int i = 0; i < indexMap.size(); ++i) {
        for (int j = 0; j < indexMap.size() - i - 1; ++j) {
            if (indexMap[j].second > indexMap[j + 1].second) {
                indexTmp = indexMap[j].first;
                valueTmp = indexMap[j].second;
                indexMap[j].first = indexMap[j + 1].first;
                indexMap[j].second = indexMap[j + 1].second;
                indexMap[j + 1].first = indexTmp;
                indexMap[j + 1].second = valueTmp;
            }
        }
    }
    for (int i = 0; i < k; ++i) {
        res.emplace_back(indexMap[i].first);
    }
    return res;
}