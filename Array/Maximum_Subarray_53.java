package Leetcode.Array;

public class Maximum_Subarray_53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > 0) nums[i] += nums[i-1];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}
