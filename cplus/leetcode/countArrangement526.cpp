//
// Created by slwhy on 2021/8/17.
//Desc:526. 优美的排列
//
#include "vector"

using namespace std;


int dfs(int n, int index, vector<bool> visited) {
    if (index > n) return 1;
    int res = 0;
    for (int i = 1; i <= n; ++i) {
        if (!visited[i] && (i % index == 0 || index % i == 0)) {
            visited[i] = true;
            res += dfs(n, index + 1, visited);
            visited[i] = false;
        }
    }
    return res;
}

int countArrangement(int n) {
    return dfs(n, 1, vector<bool>(n + 1, false));
}
