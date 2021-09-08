//
// Created by slwhy on 2021/8/5.
// Desc:802. 找到最终的安全状态
//
#include "vector"
#include "set"

using namespace std;

class Solution {
public:
    set<int> ringSet;
    set<int> safeNodes;

    bool dfs(vector<vector<int>> &graph, set<int> path, int node) {
        bool res = true;
        if (path.find(node) != path.end() || ringSet.find(node) != ringSet.end()) {
            set<int>::iterator iter;
            for (iter = path.begin(); iter != path.end(); ++iter) {
                ringSet.insert(*iter);
            }
            ringSet.insert(node);
            path.clear();
            return false;
        } else if (safeNodes.find(node) != safeNodes.end()) {
            return true;
        } else {
            path.insert(node);
            for (int i = 0; i < graph[node].size(); ++i) {
                res = dfs(graph, path, graph[node][i]);
                if (!res) break;
            }
            path.erase(node);
            if (res) safeNodes.insert(node);
            return res;
        }
    }

    vector<int> eventualSafeNodes(vector<vector<int>> &graph) {
        set<int> path;
        bool flag = true;
        vector<int> result;
        for (int i = 0; i < graph.size(); ++i) {
            path.clear();
            flag = dfs(graph, path, i);
            if (flag) result.emplace_back(i);

        }
        return result;
    }
};
