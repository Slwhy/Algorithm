//
// Created by slwhy on 2021/8/14.
// Desc:1583. 统计不开心的朋友
//

#include "vector"
#include "set"

using namespace std;

int unhappyFriends(int n, vector<vector<int>> &preferences, vector<vector<int>> &pairs) {
    /*
     * 先将pairs 以及朋友之间的优先级转换成map映射关系(用vector实现)，而后按照规则进行遍历筛选，快乐模拟
     */
    set<int> unHappyFriends;
    vector<int> pairsMap(n);
    vector<vector<int>> preferencesMap(n, vector<int>(n, -1));
    for (int i = 0; i < pairs.size(); ++i) {
        pairsMap[pairs[i][0]] = pairs[i][1];
        pairsMap[pairs[i][1]] = pairs[i][0];
    }
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n - 1; ++j) {
            preferencesMap[i][preferences[i][j]] = j;
        }
    }
    for (int i = 0; i < n; ++i) {
        if (unHappyFriends.find(i) != unHappyFriends.end()) continue;
        for (int j = preferencesMap[i][pairsMap[i]] - 1; j >= 0; --j) {

            if (preferencesMap[preferences[i][j]][pairsMap[preferences[i][j]]]>preferencesMap[preferences[i][j]][i]){
                unHappyFriends.insert(i);
                unHappyFriends.insert(preferences[i][j]);
            }
        }
    }
    return unHappyFriends.size();

}
