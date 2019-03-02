package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset_II_90 {

    /**
     * My first solution
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null | nums.length == 0) return res;
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        findSet(res, new ArrayList<>(), 0, nums, used);
        return res;
    }

    private void findSet(List<List<Integer>> res, List<Integer> track, int i,
                         int[] nums, boolean[] used) {
        if (i == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }


        if (i>0 && nums[i]==nums[i-1] && !used[i-1]) {
            // do not use num at position i
            findSet(res, track, i+1, nums, used);
        } else {
            // do not use num at position i
            findSet(res, track, i+1, nums, used);
            // use num at position i
            used[i] = true;
            track.add(nums[i]);
            findSet(res, track, i+1, nums, used);
            used[i] = false;
            track.remove(track.size()-1);
        }
    }

    /**
     * My second solution
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup_2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> track, int I, int[] nums) {
        res.add(new ArrayList<>(track));

        for (int i = I; i < nums.length; i++) {
            if (i > I && nums[i] == nums[i-1]) continue;
            track.add(nums[i]);
            backtrack(res, track, i+1, nums);
            track.remove(track.size()-1);
        }
    }
    
    public static void main(String[] args) {
        Subset_II_90 m = new Subset_II_90();
        List<List<Integer>> res = m.subsetsWithDup(new int[]{1,2,2});
        for (List<Integer> list : res) System.out.println(list);
    }
}
