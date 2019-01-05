package Leetcode.Binary_Search.Medium;

public class Search_in_Rotated_Sorted_Array_II_81 {

    /**
     * My solution: 2 * O(logn) = O(logn)
     * Find the pivot, then compare the target to pivot to decide on which side the target may fall
     *
     * @param nums
     * @param target
     * @return
     */
    public static boolean search(int[] nums, int target) {
        if (nums.length == 0) return false;
        if (nums[0] == target) return true;

        int left = 0;
        int right = nums.length - 1;
        while (nums[left] == nums[right]) {
            left ++;
            if (left == nums.length) return false;
        }

        int pivot = findPivot(left, right, nums);

        if (target > nums[nums.length-1]) return binarySearch(0, pivot-1, nums, target);
        else return binarySearch(pivot, nums.length-1, nums, target);
    }

    public static int findPivot(int left, int right, int[] nums) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= nums[right]) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public static boolean binarySearch(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }

    /**
     * Leetcode solution: O(logn)
     * Shrink the range by comparing nums[mid] with nums[left] which gives us a sorted array either on left side or
     * right side of mid
     *
     * @param nums
     * @param target
     * @return
     */
    public static boolean search_lc(int[] nums, int target) {
        if (nums.length == 0) return false;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return true;
            // The array on the left side of mid is sorted
            else if (nums[left] < nums[mid])
            {
                // [left ... target ... mid ... right]
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                // [left ... mid ... target ... right]
                else left = mid + 1;
            }
            // The array on the right side of mid is sorted
            else if (nums[left] > nums[mid])
            {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
            else left++; // nums[left] == nums[mid]
        }

        return false;
    }
}
