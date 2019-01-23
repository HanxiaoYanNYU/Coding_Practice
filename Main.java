package Leetcode;

import Leetcode.BFS.Medium.*;
import Leetcode.Binary_Search.Easy.*;
import Leetcode.Binary_Search.Medium.*;
import Leetcode.DFS.Easy.Flood_Fill_733;
import Leetcode.DFS.Medium.Decode_String_394;
import Leetcode.DFS.Medium.Friend_Circles_547;
import Leetcode.DFS.Medium.Reconstruct_Itinerary_332;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String[][] M = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
        List<String> res = null;
        System.out.println(res);
//
//        Queue<String> q = new LinkedList<>();
//
//        Map<String, String> map = new HashMap<>();
//        Stack<String> s = new Stack<>();
//        boolean[] b = new boolean[1];
//        System.out.println(b[0]);
//
//        Set<String> set = new HashSet<>();
//
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.set(0, l.get(0) + 1);
        Collections.reverse(l);


//        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
//
//        pq.add("JFK");
//        pq.add("SJC");
//        System.out.println(pq.poll());
//        System.out.println(pq.poll());

    }

    public class Solution {
        class UnionFind {
            private int count = 0;
            private int[] parent, rank;

            public UnionFind(int n) {
                count = n;
                parent = new int[n];
                rank = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int p) {
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];    // path compression by halving
                    p = parent[p];
                }
                return p;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) return;
                if (rank[rootQ] > rank[rootP]) {
                    parent[rootP] = rootQ;
                }
                else {
                    parent[rootQ] = rootP;
                    if (rank[rootP] == rank[rootQ]) {
                        rank[rootP]++;
                    }
                }
                count--;
            }

            public int count() {
                return count;
            }
        }

        public int findCircleNum(int[][] M) {
            int n = M.length;
            UnionFind uf = new UnionFind(n);
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (M[i][j] == 1) uf.union(i, j);
                }
            }
            return uf.count();
        }
    }

}
