//
// Created by slwhy on 2021/8/31.
// Desc:1109. 航班预订统计
//
#include "vector"
#include "iostream"
using namespace std;
vector<int> corpFlightBookings(vector<vector<int>>& bookings, int n) {
    vector<int> res(n,0);
    for (int i = 0; i < bookings.size(); ++i) {
        for (int j = bookings[i][0]-1; j <bookings[i][1] ; ++j) {
            res[j] += bookings[i][2];
        }
    }
    return res;
}
//int main(){
//    vector<vector<int>> bookings={{1,2,10},{2,3,20},{2,5,25}};
//    cout<<"begin"<<endl;
//    vector<int> res = corpFlightBookings(bookings,5);
//    for (int i = 0; i < 5; ++i) {
//        cout<<res[i]<< " ";
//    }
//    return 0;
//}