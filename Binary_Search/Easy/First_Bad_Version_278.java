package Leetcode.Binary_Search.Easy;

public class First_Bad_Version_278 {

    /***
     * Binary search, O(logn)
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int middle;

        while (left < right) {
            middle = left + (right - left) / 2;
            if (isBadVersion(middle)) {
                if (!isBadVersion(middle - 1)) return middle;
                else right = middle - 1;
            } else {
                if (middle + 1 <= right && isBadVersion(middle + 1)) return middle + 1;
                else left = middle + 1;
            }
        }

        //If left is not less than right, it means there is no correct version.
        //In other word, the first version is bad. Thus we return 1.
        return 1;
    }

    private boolean isBadVersion(int n) { return true; }

}
