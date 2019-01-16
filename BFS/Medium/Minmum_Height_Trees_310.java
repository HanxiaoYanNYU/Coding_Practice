package Leetcode.BFS.Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Minmum_Height_Trees_310 {

    /**
     * Leetcode Solution.
     *
     * 最小高度 其实就是这个树里 最长的路径的中间点。
     * 因为如果我们不取最长路径的中间点，而是偏向某一个端点的话，另一边的高度一定比最小高度大。
     *
     * 而取最长路径的中间点的方法是，remove current tree的所有leaf node ——> 形成新的Tree ——> 对这个新的树再remove leaf node
     * 这样一步步走 就走到了最长路径的中间点处
     *
     * @param n
     * @param edges
     * @return
     */
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if (n == 1) {
            res.add(0);
            return res;
        }

        List<Set<Integer>> neighbors = new ArrayList<>();
        // Create neighbor set for each vertex
        for (int i = 0; i < n; i++) {
            neighbors.add(new HashSet<>());
        }

        // Construct graph
        for (int[] e : edges) {
            int v1 = e[0];
            int v2 = e[1];
            neighbors.get(v1).add(v2);
            neighbors.get(v2).add(v1);
        }

        // Find all leaves at the initial state
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (neighbors.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            n = n - leaves.size();
            List<Integer> newLeves = new ArrayList<>();
            for (Integer leaf : leaves) {
                int neighbor = neighbors.get(leaf).iterator().next();
                neighbors.get(neighbor).remove(leaf);
                if (neighbors.get(neighbor).size() == 1) newLeves.add(neighbor);
            }
            leaves = newLeves;
        }

        return leaves;
    }
}
