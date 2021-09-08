//
// Created by slwhy on 2021/8/22.
// Desc:789. 逃脱阻碍者
#include "vector"
#include "cmath"

using namespace std;

bool escapeGhosts(vector<vector<int>> &ghosts, vector<int> &target) {
    /*
     * 思路：要想成功逃脱，你距离目标的距离应该比所有阻拦者到目标的距离都近，否则阻拦者直接前往目标堵你就失败了
     */
    int distance = abs(target[0]) + abs(target[1]);
    int disTmp;
    for (int i = 0; i < ghosts.size(); ++i) {
        disTmp = abs(ghosts[i][0] - target[0]) + abs(ghosts[i][1] - target[1]);
        if (disTmp <= distance) return false;
    }
    return true;
}


