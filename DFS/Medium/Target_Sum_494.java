package Leetcode.DFS.Medium;

public class Target_Sum_494 {

    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return count;
    }

    public void dfs(int[] nums, int index, int sum, int S) {
        if (index == nums.length) {
            if (sum == S) count++;
            return;
        }

        dfs(nums, index + 1, sum + nums[index], S);
        dfs(nums, index + 1, sum - nums[index], S);
    }
}
