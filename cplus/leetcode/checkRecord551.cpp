//
// Created by slwhy on 2021/8/18.
// Desc:551. 学生出勤记录 I

#include "string"

using namespace std;

bool checkRecord(string s) {
    int absent = 0, late = 0;
    for (int i = 0; i < s.size(); ++i) {
        if (absent >= 2 || late >= 3) return false;
        if (s[i] == 'A') {
            absent++;
            late = 0;
        } else if (s[i] == 'L') late++;
        else late = 0;
    }
    if (absent < 2 && late < 3) return true;
    else return false;
}
