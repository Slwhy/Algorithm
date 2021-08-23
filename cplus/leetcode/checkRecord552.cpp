//
// Created by slwhy on 2021/8/18.
//Desc:552. 学生出勤记录 II
//
#include "istream"
#include "vector"
#include "math.h"
using namespace std;
vector<vector<vector<int>>> cache;

int dfs(int n, int absent, int late) {
    /*
     * dfs 暴力搜索，超时了，带cache的暴力搜索可以过去
     *
     */
    if (n <= 0 && absent < 2 && late < 3) return 1;
    else if (absent < 2 && late < 3) {
        if (cache[n][absent][late] != -1) return cache[n][absent][late];
        long long tmp = (long long)dfs(n - 1, absent + 1, 0) + (long long)dfs(n - 1, absent, late + 1) + (long long)dfs(n - 1, absent, 0);
        int res = tmp % (int)(pow(10,9)+7);
        cache[n][absent][late] = res;
        return res;
    } else return 0;
}

int checkRecord(int n) {
    cache = vector<vector<vector<int>>>(n+1, vector<vector<int>>(2, vector<int>(3, -1)));
    return dfs(n, 0, 0);
}
