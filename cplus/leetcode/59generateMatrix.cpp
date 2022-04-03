//
// Created by slwhy on 2022/4/1.
//
#include "vector"

using namespace std;

void generateMatrixDfs(vector<vector<int>> &mat, int layer, int num) {
    // 在版本2的基础上，将3个循环优化为一个循环
    if (mat.size() / 2 > layer) {
        int leng = mat.size() - layer - layer - 1;
        for (int i = layer; i < mat.size() - layer - 1; ++i) {
            mat[layer][i] = num;
            mat[i][mat.size() - 1 - layer] = num + leng;
            mat[mat.size() - 1 - layer][mat.size() - 1 - i] = num + leng * 2;
            mat[mat.size()-1-i][layer] = num+leng*3;
            num++;
        }
        num += 3*leng;
        generateMatrixDfs(mat, layer + 1, num);
    } else if (mat.size() % 2 != 0 && mat.size() / 2 == layer) {
        mat[layer][layer] = num;
    }
}

void generateMatrixDfs2(vector<vector<int>> &mat, int layer, int num) {
    // 简单版本
    if (mat.size() / 2 > layer) {
        for (int i = layer; i < mat.size() - layer - 1; ++i) {
            mat[layer][i] = num++;
        }
        for (int i = layer; i < mat.size() - layer - 1; ++i) {
            mat[i][mat.size() - 1 - layer] = num++;
        }
        for (int i = mat.size() - 1 - layer; i > layer; i--) {
            mat[mat.size() - 1 - layer][i] = num++;
        }
        for (int i = mat.size() - 1 - layer; i > layer; i--) {
            mat[i][layer] = num++;
        }
        generateMatrixDfs2(mat, layer + 1, num);
    } else if (mat.size() % 2 != 0 && mat.size() / 2 == layer) {
        mat[layer][layer] = num;
    }
}

vector<vector<int>> generateMatrix(int n) {
    vector<vector<int>> mat = vector<vector<int>>(n, vector<int>(n, 0));
    generateMatrixDfs(mat, 0, 1);
    return mat;
}