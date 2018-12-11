package Leetcode.Binary_Search.Medium;

public class Find_First_Last_Elements_in_Sorted_Array_34 {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int[] res = new int[2];

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        res[0] = nums[left] == target ? left : -1;

        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        res[1] = nums[right] == target ? right : -1;

        return res;
    }
}
