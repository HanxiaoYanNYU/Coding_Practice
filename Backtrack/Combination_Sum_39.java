package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (target <= 0) return res;
        Arrays.sort(candidates);

        backtrack(res, new ArrayList<>(), 0, target, 0, candidates);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> track,
                           int preSum, int target, int start, int[] candidates) {
        for (int i = start; i < candidates.length; i++) {
            if (preSum + candidates[i] > target) break;

            track.add(candidates[i]);
            if (preSum + candidates[i] == target) {
                res.add(new ArrayList<>(track));
                track.remove(track.size()-1);
                break;
            }
            backtrack(res, track, preSum+candidates[i], target, i, candidates);
            track.remove(track.size()-1);
        }
    }
}
