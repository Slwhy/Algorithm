package leetcode.random;

/**
 * @author: slwhy
 * @date: 2020/3/28
 * @description: 208. 实现 Trie (前缀树)
 */

class TrieNode {
    char val;
    boolean appear = false;
    TrieNode[] children = new TrieNode[26];

    public TrieNode() {

    }

    public TrieNode(char ch) {
        val = ch;
    }
}

public class Trie {
    /**
     * Initialize your data structure here.
     */

    TrieNode root = new TrieNode();

    public Trie() {

    }


    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode curr = root;
        char[] tmp = word.toCharArray();
        for (int i = 0; i < tmp.length; i++) {
            if (curr.children[tmp[i] - 'a'] == null) {
                curr.children[tmp[i] - 'a'] = new TrieNode(tmp[i]);
            }
            curr = curr.children[tmp[i] - 'a'];
        }
        curr.appear = true;

    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] tmp = word.toCharArray();
        TrieNode curr = root;
        for (int i = 0; i < tmp.length; i++) {
            if (curr.children[tmp[i] - 'a'] != null) curr = curr.children[tmp[i] - 'a'];
            if (i==tmp.length-1) return curr.appear;
            else return false;
        }
        return curr.appear;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] tmp = prefix.toCharArray();
        TrieNode curr = root;
        for (int i = 0; i < tmp.length; i++) {
            if (curr.children[tmp[i] - 'a'] != null) curr = curr.children[tmp[i] - 'a'];
            else return false;
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
