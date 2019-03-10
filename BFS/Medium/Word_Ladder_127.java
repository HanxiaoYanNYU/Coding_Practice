package Leetcode.BFS.Medium;

import java.util.*;

public class Word_Ladder_127 {

    // Find the shortest path using BFS

    /**
     * Using BFS is the better way than DFS, since BFS helps us find the shortest path faster.
     *
     * NOTE: Leetcode change function signature from Set to List, we should convert List to Set before doing this
     * problem
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for (String s : wordList) { wordSet.add(s); }
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int length = 1;
        q.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                String curr = q.poll();
                for (int i = 0; i < curr.length(); i++) {
                    char[] currChar = curr.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        currChar[i] = c;
                        String newCurr = new String(currChar);
                        if (newCurr.equals(endWord)) return length + 1;
                        else if (wordSet.contains(newCurr) && !visited.contains(newCurr)) {
                            q.add(newCurr);
                            visited.add(newCurr);
                        }
                    }
                }
                size--;
            }
            if (q.size() == 0) return 0;
            length++;
        }
        return 0;
    }
}
