package Leetcode.Binary_Search.Medium;

public class H_Index_II_275 {

    /**
     * My solution: Binary Search, O(logn)
     * Explanation of definition of h-index in my word: There are h papers for each of them has at least h citations
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int left = 0;
        int right = citations.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == citations.length - mid) return citations[mid];
            else if (citations[mid] < citations.length - mid) left = mid + 1;
            else right = mid;
        }
        if (citations[left] < citations.length - left) return 0;
        else return citations.length - left;
    }
}
