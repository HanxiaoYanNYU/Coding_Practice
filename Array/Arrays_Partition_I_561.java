package Leetcode.Array;

import java.util.Arrays;

public class Arrays_Partition_I_561 {

    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i=i+2) {
            sum += nums[i];
        }
        return sum;
    }
}
