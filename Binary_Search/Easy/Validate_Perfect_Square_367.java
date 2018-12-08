package Leetcode.Binary_Search.Easy;

public class Validate_Perfect_Square_367 {

    /***
     * 0 is not perfect square;
     * Long type holds 8 bytes, while int type holds 4 bytes
     * Use multiply instead of divide to prevent unexpected equal, e.g. 5/2 = 2
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num <= 0) return false;

        long left = 1;
        long right = num;

        while (left <= right) {
            long middle = left + (right - left) / 2;

            if (middle * middle == num) return true;
            else if (middle * middle < num) left = middle + 1;
            else right = middle - 1;
        }
        return false;
    }
}
