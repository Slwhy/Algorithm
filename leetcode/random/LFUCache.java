package leetcode.random;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: slwhy
 * @date: 2020/4/6
 * @description: 460. LFU缓存
 */
public class LFUCache {
    HashMap<Integer, Integer> cache = new HashMap<>();
    ArrayList<Integer> lru = new ArrayList<>();
    int capaci;

    public LFUCache(int capacity) {
        capaci = capacity;
    }

    public int get(int key) {
        if (cache.keySet().contains(key)) {
            for (int i = 0; i < lru.size(); i++) {
                if (lru.get(i).equals(key)) {
                    lru.remove(i);
                    break;
                }
            }
            lru.add(0, key);
            return cache.get(key);
        } else return -1;
    }

    public void put(int key, int value) {
        if (cache.keySet().contains(key) && cache.get(key).equals(value))
            return;
        if (cache.keySet().contains(key)) {
            cache.remove(key);
            cache.put(key, value);
            for (int i = 0; i < lru.size(); i++) {
                if (lru.get(i).equals(key)) {
                    lru.remove(i);
                    break;
                }
            }
            lru.add(lru.size(), key);
        }
        if (!cache.keySet().contains(key)) {
            if (lru.size() < capaci) {
                lru.add(lru.size(), key);
                cache.put(key, value);
            } else {
                cache.remove(lru.get(lru.size() - 1));
                lru.remove(lru.size() - 1);
                lru.add(lru.size(), key);
                cache.put(key, value);
            }
        }
    }
}
