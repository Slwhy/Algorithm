//
// Created by slwhy on 2021/8/31.
// Desc:1109. 航班预订统计
//
#include "vector"
#include "iostream"

using namespace std;

vector<int> corpFlightBookings(vector<vector<int>> &bookings, int n) {
    /*
     * TODO 差分解法，第一遍没想到
     * 可以类比上车下车问题，思路参考如下
     * https://leetcode-cn.com/problems/corporate-flight-bookings/solution/5118_hang-ban-yu-ding-tong-ji-by-user9081a/
     */

    vector<int> res(n, 0);
    for (int i = 0; i < bookings.size(); ++i) {
        res[bookings[i][0] - 1] += bookings[i][2];
        if (bookings[i][1] < n) {
            res[bookings[i][1]] -= bookings[i][2];
        }
    }
    for (int i = 1; i < n; ++i) {
        res[i] = res[i] + res[i - 1];
    }
    return res;
}

vector<int> corpFlightBookings1(vector<vector<int>> &bookings, int n) {
    /*
     * 暴力，超时
     */
    vector<int> res(n, 0);
    for (int i = 0; i < bookings.size(); ++i) {
        for (int j = bookings[i][0] - 1; j < bookings[i][1]; ++j) {
            res[j] += bookings[i][2];
        }
    }
    return res;
}
int main(){
    vector<vector<int>> bookings={{1,2,10},{2,3,20},{2,5,25}};
    cout<<"begin"<<endl;
    vector<int> res = corpFlightBookings(bookings,5);
    for (int i = 0; i < 5; ++i) {
        cout<<res[i]<< " ";
    }
    return 0;
}