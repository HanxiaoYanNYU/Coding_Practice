package Leetcode.Binary_Search.Medium;

public class Rotated_Sorted_Array_33 {

    /**
     * First, use binary search find pivot (the numbers on the right side of pivot must smaller than nums[0]),
     * this takes O(logn) time
     *
     * Then, use binary search to search target, it takes O(logn) time
     *
     * Thus, O(2 * logn) = O(logn)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        // Find smallest value's position
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        int pivot = left;
        System.out.println(pivot);

        // Decide target on which side of pivot
        int L; int R;
        if (target > nums[nums.length - 1]) {
            L = 0;
            R = pivot - 1;
        } else {
            L = pivot;
            R = nums.length - 1;
        }

        // Binary search target
        while (L <= R) {
            int M = L + (R - L) / 2;
            if (nums[M] == target) return M;
            else if (nums[M] < target) {
                L = M + 1;
            } else R = M - 1;
        }

        return -1;
    }

    /**
     * My solution. Another solution.
     * Instead of finding the pivot, we compare the nums[mid] with nums[left] to find out whether
     * left side of mid is sorted in ascending order or the right side. Then shrink to range according to
     * that information.
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search_1(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[left] <= nums[mid]) {
                // left side of mid is sorted in ascending order
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                // right side of mid is sorted in ascending order
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1;
    }
}
