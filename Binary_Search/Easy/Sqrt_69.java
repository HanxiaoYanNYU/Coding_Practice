package Leetcode.Binary_Search.Easy;

public class Sqrt_69 {

    /***
     * FAILED, Time limit exceed
     * Logic correct, O(n)
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        int pre = 0;
        int curr;

        while(true) {
            curr = pre + 1;
            if (curr * curr == x) return curr;
            if (curr * curr > x) break;
            pre++;
        }

        return pre;
    }

    /***
     * Binary search, O(logn)
     *
     * @param x
     * @return
     */
    public static int mySqrt_2(int x) {
        if (x == 0) return 0;

        int left = 1;
        int right = x;

        while(true) {
            int middle = left + (right - left) / 2;
            if (middle == x / middle) return middle;
            if (middle > x / middle) {
                right = middle - 1;
            } else {
                if ((middle + 1) > x / (middle + 1)) return middle;
                left = middle + 1;
            }
        }
    }

    /**
     * My updated solution
     *
     * Rather than use (left+right)/2 as mid, we use (left+right)/2 + 1 as mid. Since we want to find the largest
     * number y that y^2 <= x.
     *
     * If we still use (left+right)/2 as mid, this may not the largest number we want
     *
     * @param x
     * @return
     */
    public int mySqrt_updated(int x) {
        if (x == 0) return 0;

        int left = 1;
        int right = x;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (mid == x/mid) return mid;
            else if (mid > x/mid) right = mid - 1;
            else left = mid;
        }
        return left;
    }
}
