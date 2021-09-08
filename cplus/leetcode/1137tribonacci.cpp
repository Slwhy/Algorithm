//
// Created by slwhy on 2021/8/8.
//

#include "iostream"
#include "vector"

using namespace std;

int tribonacci1(int n) {
    /*
     * 动态规划实现，即循环实现
     */
    vector<int> array;
    array.resize(n + 3);
    array[0] = 0;
    array[1] = 1;
    array[2] = 1;
    for (int i = 3; i <= n; ++i) {
        array[i] = array[i - 1] + array[i - 2] + array[i - 3];
    }
    return array[n];
}

int tribonacci(int n) {
    /*
     * 递归实现，不过好使较长
     */
    if (n < 2) return n;
    else if (n == 2) return 1;
    else return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
}

//int main() {
//    cout << "hello world" << endl;
//    return 0;
//}
