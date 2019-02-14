package Leetcode.Google.Onsite;

import java.util.*;

/*
    设计一个数据结构，实现输入法的自动补全功能。例如字典里有['cat', 'cats']，输入'c'，返回'cat','cats'
 */
public class Auto_Complete {

    public static void main(String[] args) {

        // test case
        Auto_Complete auto = new Auto_Complete();
        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("cap");
        dict.add("cop");
        dict.add("crab");
        dict.add("bob");
        dict.add("bobst");

        Auto_Complete.Trie trie = auto.buildTrie(dict);
        System.out.println(trie.startWith("cat"));

        trie.delete("cat");
        System.out.println(trie.startWith("cat"));
    }

    public Trie buildTrie(List<String> dict) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.insert(word);
        }
        return trie;
    }

    public class Trie {
        public TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) return;

            TrieNode curr = this.root;
            char[] c = word.toLowerCase().toCharArray();
            for (int i = 0; i < c.length; i++) {
                TrieNode child;
                if (curr.children.containsKey(c[i])) child = curr.children.get(c[i]);
                else {
                    child = new TrieNode(c[i]);
                    if (i == c.length - 1) {
                        child.isWord = true;
                        child.text = word;
                    }
                    curr.children.put(c[i], child);
                }
                curr = child;
            }
        }

        public boolean exist(String word) {
            if (word == null || word.length() == 0) return false;

            char[] C = word.toLowerCase().toCharArray();
            TrieNode curr = this.root;
            for (Character c : C) {
                if (!curr.children.containsKey(c)) return false;
                curr = curr.children.get(c);
            }

            return curr.isWord;
        }

        public boolean delete(String word) {
            if (!exist(word)) return false;

            char[] C = word.toLowerCase().toCharArray();
            TrieNode curr = this.root;
            for (Character c : C) {
                curr = curr.children.get(c);
            }
            curr.isWord = false;

            return true;
        }

        public List<String> startWith(String prefix) {
            List<String> list = new ArrayList<>();
            if (prefix == null || prefix.length() == 0) return list;

            char[] C = prefix.toLowerCase().toCharArray();
            TrieNode curr = this.root;
            for (Character c : C) {
                if (!curr.children.containsKey(c)) return list;
                curr = curr.children.get(c);
            }

            findWords(curr, list);
            return list;
        }

        void findWords(TrieNode curr, List<String> list) {
            if (curr.isWord) list.add(curr.text);

            for (TrieNode child : curr.children.values()) {
                findWords(child, list);
            }
        }
    }

    private class TrieNode {
        char c;
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord;
        String text;

        TrieNode() {}

        TrieNode(char c) {
            this.c = c;
            this.isWord = false;
            this.text = "";
        }
    }

}
