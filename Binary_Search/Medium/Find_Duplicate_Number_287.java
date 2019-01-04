package Leetcode.Binary_Search.Medium;

import java.util.List;

public class Find_Duplicate_Number_287 {

    /**
     * Think of array as linked list.
     * Ref: https://en.wikipedia.org/wiki/Cycle_detection#Tortoise_and_hare
     * Ref1: https://medium.com/solvingalgo/solving-algorithmic-problems-find-a-duplicate-in-an-array-3d9edad5ad41
     * Ref2: https://cs.stackexchange.com/questions/10360/floyds-cycle-detection-algorithm-determining-the-starting-point-of-cycle
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) return -1;

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static int repeatedNumber(int[] nums) {
        if (nums.length <= 1) return -1;

        for (int i = 0; i < nums.length; i++) {
            int pointer = Math.abs(nums[i]);
            if (nums[pointer] > 0) nums[pointer] = -nums[pointer];
            else return pointer;
        }
        return -1;
    }
}
