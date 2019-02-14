package Leetcode.Google.Onsite;

import java.util.*;

/**
 * 通过不断的减除leaf node，得到longest path的 mid point，用mid point记录的maxLen再做相应计算就可以得到最长长度
 * 借鉴LeetCode 310题第一个discussion的想法 (https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts)
 */
public class Longest_Path_in_Undirected_Graph {

    public int findLongePath(int n, int[][] edges) {
        if (n <= 2) return n;

        // map id to node. node is index 1 based object
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            map.put(i, new Node(i));
        }

        // build graph
        for (int[] e : edges) {
            int v1 = e[0];
            int v2 = e[1];
            map.get(v1).neighbors.add(map.get(v2));
            map.get(v2).neighbors.add(map.get(v1));
        }

        // find leaves
        Set<Node> leaves = new HashSet<>();
        for (Node node : map.values()) {
            if (node.neighbors.size() == 1) leaves.add(node);
        }

        // remove leaves from graph and update path length on each leaf node
        while (n > 2) {
            n -= leaves.size();
            Set<Node> newLeaves = new HashSet<>();
            for (Node leaf : leaves) {
                Node parent = leaf.neighbors.get(0);
                parent.neighbors.remove(leaf);
                if (leaf.maxLen+1 > parent.maxLen) parent.maxLen = leaf.maxLen+1;
                if (parent.neighbors.size() == 1) newLeaves.add(parent);
            }
            leaves = newLeaves;
        }

        // 减树叶到最后，只有两种可能 1）剩下一个node 2）剩下2个node。如果剩下2个node，将他们两个中任意一个的maxLen乘以2即可（
        // 因为这两个node的maxLen必定相等）。如果还剩下一个，因为这个最后一个node是通过减除他的两个leaf node得到的，在减除的过程中
        // 最后的这个node的maxLen会被更新为其中一个leaf node的maxLen + 1，所以本来应该是leafNode.maxLen * 2 + 1, 现在就
        // 变成了lastNode.maxLen * 2 - 1
        if (n == 1) return 2 * leaves.iterator().next().maxLen - 1;
        else return 2 * leaves.iterator().next().maxLen;
    }

    private class Node {
        public int id;
        public List<Node> neighbors = new LinkedList<>();
        public int maxLen = 1;

        public Node(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) {
        int n = 15;
        int[][] edges = new int[][]{{2,1},{1,3},{1,4},{4,9},{9,10},{4,5},{5,11},{5,6},{6,12},{6,7},
                {7,8},{12,13},{12,14},{14,15}};
        int res = new Longest_Path_in_Undirected_Graph().findLongePath(n, edges);
        System.out.println(res);
    }
}
