//
// Created by slwhy on 2021/9/1.
// Desc: 165. 比较版本号
//
#include "string"

using namespace std;

int compareVersion(string version1, string version2) {
    /*
     * 思路不难，先将版本号按分隔符分开，而后将对应的修订号转换为数值，而后进行比较大小
     */
    int i=0, j=0, num1=0, num2 = 0;
    while (i < version1.size() || j < version2.size()) {
        num1=0, num2 = 0;
        for (; i < version1.size() && version1[i] != '.'; ++i) {
            num1 = num1 * 10 + version1[i]-'0';
        }
        i++;
        for (; j < version2.size() && version2[j] != '.'; ++j) {
            num2 = num2 * 10 + version2[j]-'0';
        }
        j++;
        if (num1 > num2) return 1;
        else if (num1 < num2) return -1;
    }
    return 0;
}