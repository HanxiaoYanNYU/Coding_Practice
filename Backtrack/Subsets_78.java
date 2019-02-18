package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        String s = "";
        s.substring(1);
        findSet(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void findSet(List<List<Integer>> res, List<Integer> track, int[] nums, int i) {
        if (i == nums.length) {
            res.add(new ArrayList(track));
            return;
        }

        // do not put current num into track
        findSet(res, track, nums, i+1);

        // put num in current position into track
        track.add(nums[i]);
        findSet(res, track, nums, i+1);
        track.remove(track.size()-1);
    }
}
