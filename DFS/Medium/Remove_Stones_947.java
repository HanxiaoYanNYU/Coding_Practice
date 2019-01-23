package Leetcode.DFS.Medium;

import java.util.HashSet;
import java.util.Set;

public class Remove_Stones_947 {

    public int removeStones(int[][] stones) {
        if (stones == null || stones.length == 0) return 0;

        Set<int[]> removed = new HashSet<>();
        int islands = 0;
        for (int[] s : stones) {
            if (removed.contains(s)) continue;
            islands++;
            dfsRemove(stones, removed, s);
        }
        return stones.length - islands;
    }

    public void dfsRemove(int[][] stones, Set<int[]> removed, int[] s) {
        removed.add(s);
        for (int[] stone : stones) {
            if (removed.contains(stone)) continue;
            if (s[0] == stone[0] || s[1] == stone[1]) dfsRemove(stones, removed, stone);
        }
    }
}
