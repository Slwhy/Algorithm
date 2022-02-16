//
// Created by slwhy on 2022/2/15.
//
#include "vector"

using namespace std;

int direc[4][2] = {{1,  0},
                   {-1, 0},
                   {0,  1},
                   {0,  -1}};

int dfs(vector<vector<int>> &grid, int row, int column) {
    if (row>=0 && column>=0 && row< grid.size() && column<grid[0].size() && grid[row][column] == 1) {
        int area = 1;
        grid[row][column] = -1;
        for (int i = 0; i < 4; ++i) {
            area += dfs(grid, row + direc[i][0], column + direc[i][1]);
        }
        return area;
    } else return 0;
}

int maxAreaOfIsland(vector<vector<int>> &grid) {
    int maxArea = 0;
    int area = 0;
    for (int i = 0; i < grid.size(); ++i) {
        for (int j = 0; j < grid[0].size(); ++j) {
            area = dfs(grid, i, j);
            maxArea = maxArea > area ? maxArea : area;
        }
    }
    return maxArea;
}
