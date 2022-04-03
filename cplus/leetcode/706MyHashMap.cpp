//
// Created by slwhy on 2022/3/28.
//
#include "vector"
#include "list"

using namespace std;

class MyHashMap {
public:
    vector<int> items;
    vector<list<pair<int, int>>> data;
    static const int base = 1000;

    MyHashMap() : data(base) {
        //items = vector<int>(1000001, -1);

    }

    int getHash(int key) {
        return key % base;
    }

    void put(int key, int value) {
        int h = getHash(key);
        for (auto itr = data[h].begin(); itr != data[h].end(); itr++) {
            if (itr->first == key) {
                itr->second = value;
                return;
            }
        }
        data[h].emplace_back(pair<int, int>(key, value));
    }

    int get(int key) {
        int h = getHash(key);
        for (auto itr = data[h].begin(); itr != data[h].end(); itr++) {
            if (itr->first == key) return itr->second;
        }
        return -1;
    }

    void remove(int key) {
        int h = getHash(key);
        for (auto itr = data[h].begin(); itr != data[h].end(); itr++) {
            if (itr->first == key) {
                data[h].erase(itr);
                break;
            }
        }
    }
};
