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
}
