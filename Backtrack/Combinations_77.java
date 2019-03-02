package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations_77 {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) return res;

        findAll(res, new ArrayList<>(), 1, n, k);
        return res;
    }

    private void findAll(List<List<Integer>> res, List<Integer> track, int start, int n, int k) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (k-track.size() > n-i+1) break;
            track.add(i);
            findAll(res, track, i+1, n, k);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        Combinations_77 m = new Combinations_77();
        List<List<Integer>> res = m.combine(2,2);
    }

}
