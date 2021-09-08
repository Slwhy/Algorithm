//
// Created by slwhy on 2021/8/2.
// Desc:743. 网络延迟时间
//
#include "vector"
#include "map"

using namespace std;

map<int, vector<pair<int, int>>> graphMap;
//map<int, int> costTime;
//vector<vector<pair<int, int>>> graphMap;
vector<int> costTime;

void dfs(int currNode, int cost) {
    if (costTime[currNode] == -1 || cost < costTime[currNode]) {
        costTime[currNode] = cost;
        for (int i = 0; i < graphMap[currNode].size(); ++i) {
            dfs(graphMap[currNode][i].first, cost + graphMap[currNode][i].second);
        }
    }
}

int networkDelayTime(vector<vector<int>> &times, int n, int k) {

    for (int i = 0; i < times.size(); ++i) {
        graphMap[times[i][0]].emplace_back(pair<int, int>(times[i][1], times[i][2]));
    }
    for (int i = 1; i <= n; ++i) {
        costTime[i] = -1;
    }
    dfs(k, 0);
    int costTimeMax = 0;
    for (int i = 1; i <= n; ++i) {
        if (costTime[i] == -1) return -1;
        else if (costTimeMax < costTime[i]) costTimeMax = costTime[i];
    }
    return costTimeMax;

}
