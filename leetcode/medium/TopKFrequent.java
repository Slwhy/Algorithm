package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/4/9
 * @description: 347. 前 K 个高频元素
 */

class HeapNode {
    int value;
    int freq;

    public HeapNode() {

    }

    public HeapNode(int num, int fre) {
        value = num;
        freq = fre;
    }

}

class MinHeap {
    ArrayList<HeapNode> heap;
    int topN;
    int tail = 0;

    public MinHeap() {

    }

    public MinHeap(int k) {
        heap = new ArrayList<>(k);
        topN = k;
    }

    public void buildHeap(HeapNode node) {
        heap.add(tail, node);
        tail++;
        floating(tail - 1);

    }

    public void adjustHeap(HeapNode node) {
        if (node.freq > heap.get(0).freq) {
            heap.remove(0);
            heap.add(0, node);
            sinking();
        }
    }

    public void sinking() {
        int tmpFreq;
        int tmpValue;
        int father = 0;
        int children;
        while (father < topN / 2) {
            if (father * 2 + 2 < topN)
                children = heap.get(father * 2 + 1).freq > heap.get(father * 2 + 2).freq ? father * 2 + 2 : father * 2 + 1;
            else children = father * 2 + 1;
            if (heap.get(father).freq > heap.get(children).freq) {
                tmpFreq = heap.get(father).freq;
                tmpValue = heap.get(father).value;
                heap.get(father).freq = heap.get(children).freq;
                heap.get(father).value = heap.get(children).value;
                heap.get(children).freq = tmpFreq;
                heap.get(children).value = tmpValue;
                father = children;
            } else break;
        }

    }

    public void floating(int index) {
        int father;
        HeapNode tmpNode;
        while (index > 0) {
            father = (index - 1) / 2;
            if (heap.get(index).freq < heap.get(father).freq) {
                tmpNode = heap.get(index);
                heap.remove(index);
                heap.add(index, heap.get(father));
                heap.remove(father);
                heap.add(father, tmpNode);
                index = father;
            } else break;
        }
    }

}

public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqs = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            if (freqs.keySet().contains(i)) {
                freqs.put(i, freqs.get(i) + 1);
            } else freqs.put(i, 1);
        }
        MinHeap minHeap = new MinHeap(k);
        for (Integer i : freqs.keySet()) {
            HeapNode node = new HeapNode(i, freqs.get(i));
            if (minHeap.heap.size() < k) minHeap.buildHeap(node);
            else minHeap.adjustHeap(node);
        }
        for (HeapNode node : minHeap.heap) {
            res.add(node.value);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 1, -1, -8, -7, 8, -5, 0, 1, 10, 8, 0, -4, 3, -1, -1, 4, -5, 4, -3, 0, 2, 2, 2, 4, -2, -4, 8, -7, -7, 2, -8, 0, -8, 10, 8, -8, -2, -9, 4, -7, 6, 6, -1, 4, 2, 8, -3, 5, -9, -3, 6, -8, -5, 5, 10, 2, -5, -1, -5, 1, -3, 7, 0, 8, -2, -3, -1, -5, 4, 7, -9, 0, 2, 10, 4, 4, -4, -1, -1, 6, -8, -9, -1, 9, -9, 3, 5, 1, 6, -1, -2, 4, 2, 4, -6, 4, 4, 5, -5};
        TopKFrequent test = new TopKFrequent();
        for (Integer i : test.topKFrequent(array, 7)) {
            System.out.println(i);
        }
    }
}
