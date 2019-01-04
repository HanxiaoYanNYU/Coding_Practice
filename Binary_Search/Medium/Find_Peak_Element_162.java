package Leetcode.Binary_Search.Medium;

public class Find_Peak_Element_162 {

    /**
     * Binary search to reduce half of array, since we only need to find ONE of the peaks
     * Ref: https://www.youtube.com/watch?v=HtSuA80QTyo&t=22s start from 28:24
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (left == right) return left;

            int middle = left + (right - left) / 2;
            int middleR = middle + 1;
            int middleL = middle - 1;

            int middleValue = nums[middle];
            int leftValue = middleL < left ? Integer.MIN_VALUE : nums[middleL];
            int rightValue = middleR > right ? Integer.MIN_VALUE : nums[middleR];

            if (middleValue > leftValue && middleValue > rightValue) return middle;
            else if (middleValue < leftValue) right = middleL;
            else left = middleR;
        }

        return -1;
    }

    /**
     * My updated solution. Use binary search, the while condition is "left < right" rather than "<="
     *
     * @param nums
     * @return
     */
    public static int findPeakElement_updated(int[] nums) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid-1] > nums[mid]) right = mid - 1;
            else if (nums[mid] < nums[mid+1]) left = mid + 1;
            else return mid; // nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1], which means mid is a peak
        }
        return left;
    }
}
