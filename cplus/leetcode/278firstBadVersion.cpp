//
// Created by slwhy on 2021/7/31.
// Desc:278. 第一个错误的版本
//

bool isBadVersion(int version) {
    return false;
}

int firstBadVersion1(int n) {
    /*
     * 暴力
     */
    for (int i = 0; i < n; ++i) {
        if (isBadVersion(i)) return i;
    }
    return -1;
}

int firstBadVersionCore(int left, int right) {
    /*
     * 递归版的二分法
     */
    if (left <= right) {
        int mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            if (mid > 1 && isBadVersion(mid - 1)) return firstBadVersionCore(left, mid - 1);
            else return mid;
        } else {
            return firstBadVersionCore(mid + 1, right);
        }
    } else return -1;
}

int firstBadVersion(int n) {
    /*
     * 二分循环版本
     */
    int left = 1, right = n;
    int mid;
    while (left <= right) {
        mid = left + (right - left) / 2;
        if (isBadVersion(mid)) {
            if (mid > 1 and isBadVersion(mid - 1)) {
                right = mid - 1;
            } else return mid;
        } else {
            left = mid + 1;
        }
    }
    return -1;
}

