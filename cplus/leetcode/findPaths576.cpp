//
// Created by slwhy on 2021/8/15.
// Desc:576. 出界的路径数
//

#include "vector"
#include "cmath"

using namespace std;


vector<vector<int>> moving = {{-1, 0},
                              {1,  0},
                              {0,  -1},
                              {0,  1}};

vector<vector<vector<int>>> cache;

long long dfs(int rowNum, int columnNum, int movRemain, int row, int column) {
    /*
     * TODO dfs 解法，第一遍超时了，没有想到利用三维数组做缓存
     */
    if (movRemain > 0 && row >= 0 && row < rowNum && column >= 0 && column < columnNum) {
        if (cache[row][column][movRemain] != -1) return cache[row][column][movRemain];
        long long num = 0;
        for (int i = 0; i < moving.size(); ++i) {
            num += dfs(rowNum, columnNum, movRemain - 1, row + moving[i][0], column + moving[i][1]);
        }
        num = num % (int) (pow(10, 9) + 7);
        cache[row][column][movRemain] = num;
        return num;
    } else if (row < 0 || row >= rowNum || column < 0 || column >= columnNum) return 1;
    else return 0;
}

int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
    cache = vector<vector<vector<int>>>(m, vector<vector<int>>(n, vector<int>(maxMove + 1, -1)));
    long long res = dfs(m, n, maxMove, startRow, startColumn);
    return (int) res % (int) (pow(10, 9) + 7);
}

int findPaths1(int m, int n, int maxMove, int startRow, int startColumn) {
    //TODO dp 解法存在问题，有些case无法过去，尚未发现
    vector<vector<vector<int>>> dp(m, vector<vector<int>>(n, vector<int>(maxMove + 1, 0)));
    int boundary;
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            boundary = 0;
            if (i == 0 || i == m - 1) boundary++;
            if (j == 0 || j == n - 1) boundary++;
            for (int k = 1; k < maxMove + 1; ++k) {
                dp[i][j][k] = boundary;
            }
        }
    }
    for (int mov = 1; mov <= maxMove; ++mov) {
        for (int j = 0; j < m; ++j) {
            for (int k = 0; k < n; ++k) {
                //当前位置等于四个方向的路径和
                for (int l = 0; l < moving.size(); ++l) {
                    int rowIdx = j + moving[l][0];
                    int colIdx = k + moving[l][1];
                    if (rowIdx >= 0 && rowIdx < m && colIdx >= 0 && colIdx < m) {
                        dp[j][k][mov] += dp[rowIdx][colIdx][mov - 1];
                        dp[j][k][mov] %= (int) (pow(10, 9) + 7);
                    }
                }
            }
        }
    }
    return dp[startRow][startColumn][maxMove];
}
