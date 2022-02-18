//
// Created by slwhy on 2022/2/17.
//
#include "vector"
#include "queue"

using namespace std;

int bfs(vector<vector<int>> &grid) {
    vector<vector<int>> direction = {{1,  0},
                                     {-1, 0},
                                     {0,  1},
                                     {0,  -1}};
    queue<vector<int>> queue;
    int min;
    for (int i = 0; i < grid.size(); ++i) {
        for (int j = 0; j < grid[0].size(); ++j) {
            if (grid[i][j] == 2) queue.push({i, j});
        }
    }
    min = queue.empty() ? 0 : -1;
    while (!queue.empty()) {
        int len = queue.size();
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < direction.size(); ++j) {
                int row = queue.front()[0] + direction[j][0];
                int column = queue.front()[1] + direction[j][1];
                if (row >= 0 && column >= 0 && row < grid.size() && column < grid[0].size() && grid[row][column] == 1) {
                    grid[row][column] = 2;
                    queue.push({row, column});
                }
            }
            queue.pop();
        }
        min++;
    }
    for (int i = 0; i < grid.size(); ++i) {
        for (int j = 0; j < grid[0].size(); ++j) {
            if (grid[i][j] == 1) return -1;
        }
    }
    return min;

}

int orangesRotting(vector<vector<int>> &grid) {
    return bfs(grid);
}