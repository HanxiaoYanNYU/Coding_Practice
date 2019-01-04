package Leetcode.Binary_Search.Medium;

public class Find_Min_Rotated_Array_153 {

    public int findMin(int[] nums) {
        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return nums[left];
    }

    /**
     * This solution is identical to the upper one, while this one is easier to understand and trace through.
     *
     * @param nums
     * @return
     */
    public int findMin_updated_solution(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) right = mid; // This is the updated part
            else left = mid + 1;
        }
        return nums[left];
    }
}
