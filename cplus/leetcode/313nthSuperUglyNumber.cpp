//
// Created by slwhy on 2021/8/9.
// Desc:313. 超级丑数
//
#include "vector"
#include "unordered_set"
#include "queue"

using namespace std;

int nthSuperUglyNumber(int n, vector<int> &primes) {
    unordered_set<long> seen;
    priority_queue<long, vector<long>, greater<long>> heap;
    seen.insert(1);
    heap.push(1);
    int ugly = 0;
    for (int i = 0; i < n; i++) {
        long curr = heap.top();
        heap.pop();
        ugly = (int) curr;
        for (int prime : primes) {
            long next = curr * prime;
            if (seen.insert(next).second) {
                heap.push(next);
            }
        }
    }
    return ugly;
}
