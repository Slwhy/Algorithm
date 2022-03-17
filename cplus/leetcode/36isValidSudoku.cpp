//
// Created by slwhy on 2022/3/16.
//
#include "vector"

using namespace std;

bool isValidSudoku(vector<vector<char>> &board) {
    vector<vector<int>> rows(9, vector<int>(9, 0));
    vector<vector<int>> columns(9, vector<int>(9, 0));
    vector<vector<int>> blocks(9, vector<int>(9, 0));
    int row, column, block;
    for (int i = 0; i < 9; ++i) {
        for (int j = 0; j < 9; ++j) {
            row = i;
            column = j;
            block = row / 3 * 3 + column / 3;
            if (board[i][j] == '.') continue;
            int val = board[i][j] - '1';
            if (rows[row][val] != 0 or columns[column][val] != 0 or
                blocks[block][val] != 0)
                return false;
            else {
                rows[row][val] = 1;
                columns[column][val] = 1;
                blocks[block][val] = 1;
            }
        }
    }
    return true;

}