package leetcode.random;


import java.util.HashMap;


/**
 * @author: slwhy
 * @date: 2020/4/8
 * @description: 146. LRU缓存机制
 */

class Node {
    int key, value;
    Node pre, next;

    public Node() {

    }

    public Node(int k, int v) {
        key = k;
        value = v;
    }
}

class DoubleList {
    Node head;
    Node tail;

    public DoubleList() {
        Node node = new Node();
        Node node1 = new Node();
        head = node;
        tail = node1;
        head.next = tail;
        tail.pre = head;
    }

    public void add(Node node) {
        tail.pre.next = node;
        node.next = tail;
        node.pre = tail.pre;
        tail.pre = node;
    }

    public void delete(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

}

public class LRUCache {

    int lent;
    HashMap<Integer, Node> cache;

    DoubleList doubleList;

    public LRUCache(int capacity) {
        lent = capacity;
        cache = new HashMap<>(lent);
        doubleList = new DoubleList();
    }

    public int get(int key) {
        if (cache.keySet().contains(key)) {
            doubleList.delete(cache.get(key));
            doubleList.add(cache.get(key));
            return cache.get(key).value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (cache.keySet().contains(key)) {
            doubleList.delete(cache.get(key));
        } else if (cache.size() >= lent) {
            cache.remove(doubleList.head.next.key);
            doubleList.delete(doubleList.head.next);
        }
        Node node = new Node(key, value);
        doubleList.add(node);
        cache.put(key, node);
    }
}
