package Leetcode.Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_II_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        List<Integer> track = new ArrayList<>();
        permute(nums, track, list, used);
        return list;
    }

    private void permute(int[] nums, List<Integer> track, List<List<Integer>> list, boolean[] used) {
        if (track.size() == nums.length) {
            list.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (used[i]) continue;
            // 值相同的元素只允许有一种排列方式(如： 对于[1, 1] 只有一种排序方法)， 而控制只有一种排序方法的办法是：
            // 值相同的元素顺序必须是先用数组中最左边出现的，然后再用右边出现的，而不接受其他排序方式，这样就做到了对
            // 排序的限制。!used[i - 1] 很关键
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            track.add(nums[i]);
            permute(nums, track, list, used);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }
}
