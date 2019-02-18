package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        backtrack(res, new ArrayList<>(), nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> track, int[] nums) {
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) continue;
            track.add(nums[i]);
            backtrack(res, track, nums);
            track.remove(track.size()-1);
        }
    }

    public static void main(String[] args) {
        Permutations_46 m = new Permutations_46();
        List<List<Integer>> res = m.permute(new int[]{1,2,3});
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
