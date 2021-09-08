//
// Created by slwhy on 2021/7/31.
// Desc:
//
#include "string"
#include "iostream"
using namespace std;

int titleToNumber(string columnTitle) {
    int res = 0;
    for (int i = 0; i < columnTitle.size(); i++) {
        res = res * 26 + (columnTitle[i] - 'A' + 1);
    }
    return res;
}

//
//int main(){
//    int res = titleToNumber("ZY");
//    cout << res << endl;
//    return 0;
//}


