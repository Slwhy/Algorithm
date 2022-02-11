//
// Created by slwhy on 2021/9/8.
//Desc:1185. 一周中的第几天
#include "string"
#include "vector"
#include "iostream"

using namespace std;

string dayOfTheWeek(int day, int month, int year) {
    vector<string> weeks = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
    vector<int> monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int days = 0;
    int runYear = (year - 1969) / 4 > 0 ? (year - 1969) / 4 : 0;
    days = (year - 1971) * 365 + runYear;
    for (int i = 0; i < month - 1; ++i) {
        days += monthDays[i];
    }
    days += day;
    if ((year % 400 == 0 || year % 100 != 0 && (year - 1972) % 4 == 0) && month > 2) {
        days += 1;
    }
    return weeks[(days - 1) % 7];
}

//int main() {
//    cout << dayOfTheWeek(1, 1, 2100) << endl;
//}

