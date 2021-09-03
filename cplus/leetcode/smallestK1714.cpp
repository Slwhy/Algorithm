//
// Created by slwhy on 2021/9/3.
//Desc:面试题 17.14. 最小K个数
//
#include "vector"
#include "algorithm"
#include "queue"

using namespace std;

void swap(vector<int> &arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
}

void sinking(vector<int> &arr, int i) {
    if (i * 2 + 1 < arr.size() && arr[i] < arr[i * 2 + 1]) {
        swap(arr, i, i * 2 + 1);
        sinking(arr, i * 2 + 1);

    }
    if (i * 2 + 2 < arr.size() && arr[i] < arr[i * 2 + 2]) {
        swap(arr, i, i * 2 + 2);
        sinking(arr, i * 2 + 2);
    }
}

vector<int> smallestK2(vector<int> &arr, int k) {
    /*
     * TODO 利用数组手动实现大根队，存在问题
     */
    if (k < 1) return vector<int>(k);
    vector<int> bigHeap(k, INT_MAX);
    for (int i = 0; i < arr.size(); i++) {
        if (i < k) {
            bigHeap[i] = arr[i];
        } else if (arr[i] < bigHeap[0]) {
            bigHeap[0] = arr[i];
            sinking(bigHeap, 0);
        }
        if (i == k - 1) {
            for (int j = k / 2 - 1; j >= 0; j--) {
                sinking(arr, j);
            }
        }
    }
    return bigHeap;
}

vector<int> smallestK3(vector<int> &arr, int k) {
    /*
     * 优先级队列实现，思路很简单，借用优先级队列充当大根堆
     */
    vector<int> vec(k, 0);
    if (k == 0) { // 排除 0 的情况
        return vec;
    }
    priority_queue<int> Q;
    for (int i = 0; i < k; ++i) {
        Q.push(arr[i]);
    }
    for (int i = k; i < (int) arr.size(); ++i) {
        if (Q.top() > arr[i]) {
            Q.pop();
            Q.push(arr[i]);
        }
    }
    for (int i = 0; i < k; ++i) {
        vec[i] = Q.top();
        Q.pop();
    }
    return vec;
}


vector<int> smallestK(vector<int> &arr, int k) {
    /*
     * 排序法，思路简单
     */
    sort(arr.begin(), arr.end());
    vector<int> res(k);
    for (int i = 0; i < k; i++) {
        res[i] = arr[i];
    }
    return res;
}

