//
// Created by slwhy on 2022/2/17.
//
#include "vector"
#include "queue"

using namespace std;


void updateMatrixBfs(vector<vector<int>> &mat) {
    // 多源BFS
    vector<vector<int>> direction = {{1,  0},
                                     {-1, 0},
                                     {0,  1},
                                     {0,  -1}};
    queue<vector<int>> queue;
    int dis = 1;
    int len = 0;
    int row, column;
    for (int i = 0; i < mat.size(); ++i) {
        for (int j = 0; j < mat[0].size(); ++j) {
            if (mat[i][j] == 0) queue.push({i, j});
            else mat[i][j] = -1;
        }
    }
    while (!queue.empty()) {
        len = queue.size();
        for (int i = 0; i < len; ++i) {
            row = queue.front()[0];
            column = queue.front()[1];
            queue.pop();
            for (int j = 0; j < direction.size(); ++j) {
                int rowNext = row + direction[j][0];
                int columnNext = column + direction[j][1];
                if (rowNext>=0 && columnNext >=0 && rowNext<mat.size() && columnNext<mat[0].size() && mat[rowNext][columnNext]==-1)
                {
                    mat[rowNext][columnNext]=dis;
                    queue.push({rowNext,columnNext});
                }
            }
        }
        dis++;
    }

}

vector<vector<int>> updateMatrix(vector<vector<int>> &mat) {
    updateMatrixBfs(mat);
    return mat;
}

//int main(){
//    vector<vector<int>> mat = {{0,1,0},{0,1,0},{0,1,0},{0,1,0},{0,1,0}};
//    updateMatrix(mat);
//}

