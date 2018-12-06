package Leetcode.Binary_Search.Easy;

public class Peak_Index_in_Mountain_852 {
    /***
     * Brute force, O(n)
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        int position = 0;
        int maxHeight = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] > maxHeight) {
                position = i;
                maxHeight = A[i];
            }
        }

        if (position == 0 || position == A.length - 1) return -1;

        for (int i = 0; i < position; i++) {
            if (A[i] >= A[i + 1]) return -1;
        }
        for (int i = position + 1; i < A.length; i++) {
            if (A[i - 1] <= A[i]) return -1;
        }

        return position;
    }

    /***
     * Binary search, O(logn)
     * This solution request the input array A must be a mountain, such that [0,1,3,4,|6|,5,3]
     * If A is [0,1,3,4,|6|,5,|6|,3], then this solution not works
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray_2(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int middle;

        while (left < right) {
            middle = left + (right - left) / 2;
            if (A[middle] > A[middle + 1]) {
                if (A[middle] > A[middle - 1]) return middle;
                right = middle;
            } else {
                left = middle;
            }
        }
        return -1;
    }
}
