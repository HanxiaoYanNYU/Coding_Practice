package Leetcode.Backtrack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Add_Search_Word_211 {

    private TrieNode root;

    /** Initialize your data structure here. */
    public Add_Search_Word_211() {
        this.root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.equals("")) return;
        TrieNode currNode = this.root;
        char[] words = word.toCharArray();

        for (int i = 0; i < words.length; i++) {
            if (!currNode.children.containsKey(words[i])) {
                currNode.children.put(words[i], new TrieNode(words[i]));
            }
            currNode = currNode.children.get(words[i]);
        }
        currNode.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word == null || word.equals("")) return false;
        char[] words = word.toCharArray();
        Queue<TrieNode> q = new LinkedList<>();
        for (TrieNode child : this.root.children.values()) q.add(child);

        for (int i = 0; i < words.length; i++) {
            int size = q.size();
            while (size > 0) {
                TrieNode node = q.poll();
                if (i == words.length-1 && node.isWord) {
                    if (words[i] == '.' || words[i] == node.c) return true;
                } else if (words[i] == '.' || words[i] == node.c) {
                    for (TrieNode child : node.children.values()) q.add(child);
                }
                size--;
            }
        }
        return false;
    }

    private class TrieNode {
        public char c;
        public boolean isWord = false;
        public Map<Character, TrieNode> children = new HashMap<>();

        public TrieNode() {}
        public TrieNode(char c) { this.c = c; }
    }

    public static void main(String[] args) {
        Add_Search_Word_211 solution = new Add_Search_Word_211();
        solution.addWord("bad");
        solution.addWord("dad");
        solution.addWord("mad");
        solution.search("pad");
        solution.search("bad");
        solution.search(".ad");
        solution.search("b..");
    }
}